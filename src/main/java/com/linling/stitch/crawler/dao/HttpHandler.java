package com.linling.stitch.crawler.dao;

import com.linling.stitch.crawler.common.FetchStatus;
import com.linling.stitch.crawler.common.HttpHeader;
import com.linling.stitch.crawler.common.HttpMethods;
import com.linling.stitch.crawler.common.HttpStatus;
import com.linling.stitch.crawler.configs.FetchConfigs;
import com.linling.stitch.crawler.data.RequestEntity;
import com.linling.stitch.crawler.data.ResponseEntity;
import com.linling.stitch.crawler.selector.RandomCipherSuitesSelector;
import com.linling.stitch.crawler.selector.RoundProxySelector;
import com.linling.stitch.crawler.selector.UserAgentSelector;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.linling.stitch.crawler.common.ApiConstants.Proxy_None;
import static com.linling.stitch.crawler.common.FetchStatus.FetchCode.*;

@Component
@Slf4j
public class HttpHandler {

    @Autowired
    private RoundProxySelector roundProxySelector;

    @Autowired
    private FetchConfigs fetchConfigs;

    @Autowired
    private UserAgentSelector userAgentSelector;

    @Autowired
    private RandomCipherSuitesSelector cipherSuitesSelector;

    private HttpClient httpClient;

    public final static ThreadLocal<String> caller = new ThreadLocal<>();

    private HttpClient initHttpClient() throws Exception {
        HttpClient.Builder builder  = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.ALWAYS);

        if (fetchConfigs.isTlsTrustAllCerts()) {
            log.info("fetch-config 'tlsTrustAllCerts' is true");
            TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[] {};
                }

                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }
            } };
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            builder.sslContext(sc);
        }

        if (fetchConfigs.isProxyActive()) {
            log.info("fetch-config 'proxyActive' is true");
            builder.proxy(roundProxySelector);
        }

        if (fetchConfigs.isDynamicCipherSuites()) {
            log.info("fetch-config 'dynamicCipherSuites' is true");
            Class<?> clazz = builder.getClass();
            Field sslParams = clazz.getDeclaredField("sslParams");
            sslParams.setAccessible(true);
            sslParams.set(builder, cipherSuitesSelector);
        }

        return builder.build();
    }

    @PostConstruct
    public void init() throws Exception {
        httpClient = initHttpClient();
    }

    private void preprocess(RequestEntity req) {
        req.setMethod(Optional.ofNullable(req.getMethod()).filter(StringUtils::isNotBlank).orElse(HttpMethods.GET));

        if (req.getTimeout() < 1) {
            req.setTimeout(fetchConfigs.getTimeout());
        }

        req.setHeader(Optional.ofNullable(req.getHeader()).orElse(new HashMap<>()));

        if (req.getHeader().entrySet().stream().noneMatch(e -> e.getKey().equalsIgnoreCase(HttpHeader.User_Agent))) {
            req.getHeader().put(HttpHeader.User_Agent, userAgentSelector.select(req.getUrl()));
        }

        req.setBody(Optional.ofNullable(req.getBody()).orElse(new byte[0]));

        if (fetchConfigs.isProxyActive()) {
            HttpHandler.caller.set(Optional.ofNullable(req.getProxy()).filter(Proxy_None::equalsIgnoreCase).map(p -> Proxy_None).orElse(req.getProxy()));
        }
    }

    public ResponseEntity request(RequestEntity req) {
        preprocess(req);
        ResponseEntity resp = new ResponseEntity();
        resp.setFetchUrl(req.getUrl());
        long startT = System.currentTimeMillis();
        try {
            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(URI.create(req.getUrl()))
                    .method(req.getMethod(), HttpRequest.BodyPublishers.ofByteArray(req.getBody()))
                    .timeout(Duration.ofSeconds(req.getTimeout()));
            Optional.ofNullable(req.getHeader())
                    .filter(h -> !h.isEmpty())
                    .ifPresent(h -> requestBuilder.headers(h.entrySet().stream().flatMap(e -> Stream.of(e.getKey(), e.getValue())).collect(Collectors.toList()).toArray(new String[]{})));

            resp.setTs(startT/1000);

            HttpResponse<byte[]> response = httpClient.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofByteArray());

            resp.setRealUrl(response.uri().toString());
            resp.setHttpCode(response.statusCode());
            resp.setHttpMsg(HttpStatus.getStatusText(response.statusCode()));
            resp.setHeader(response.headers().map().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry-> Strings.join(entry.getValue(),','))));
            resp.setBody(response.body());
            resp.setProto(response.version().name());
            resp.setStatus(FetchStatus.of(SUCCESS));
            resp.setCost(System.currentTimeMillis() - startT);
            resp.setProxy(caller.get());
            resp.setRequestEntity(req);

        } catch (HttpTimeoutException e) {
            log.error("request fail. url : {} ; err : {}", req.getUrl(), e);
            resp.setStatus(FetchStatus.of(TIMEOUT_ERROR, e.getMessage()));
            resp.setCost(System.currentTimeMillis() - startT);
        } catch (SecurityException | InterruptedException e) {
            log.error("request fail. url : {} ; err : {}", req.getUrl(), e);
            resp.setStatus(FetchStatus.of(FETCHED_ERROR, e.getMessage()));
            resp.setCost(System.currentTimeMillis() - startT);
        } catch (IllegalArgumentException e) {
            log.error("request fail. url : {} ; err : {}", req.getUrl(), e);
            resp.setStatus(FetchStatus.of(ILLEGAL_ARGUMENT_ERROR, e.getMessage()));
            resp.setCost(System.currentTimeMillis() - startT);
        } catch (IOException e) {
            log.error("request fail. url : {} ; err : {}", req.getUrl(), e);
            resp.setStatus(FetchStatus.of(IO_ERROR, e.getMessage()));
            resp.setCost(System.currentTimeMillis() - startT);
        } finally {
            caller.remove();
        }

        return resp;
    }

}
