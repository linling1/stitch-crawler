package com.linling.stitch.crawler.selector;

import com.google.common.collect.Lists;
import com.linling.stitch.crawler.configs.FetchConfigs;
import com.linling.stitch.crawler.dao.HttpHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.linling.stitch.crawler.common.ApiConstants.Proxy_None;

@Component
@Slf4j
public class RoundProxySelector extends ProxySelector {

    @Autowired
    private FetchConfigs fetchConfigs;

    private final AtomicInteger index = new AtomicInteger(0);

    @Override
    public List<Proxy> select(URI uri) {
        List<Proxy> proxyList = new ArrayList<>();
        if (fetchConfigs.getProxies().isEmpty()) {
            return proxyList;
        }
        try {
            String specialProxy = HttpHandler.caller.get();
            String proxyUrl = null;
            if (StringUtils.isBlank(specialProxy)) {
                int offset = index.addAndGet(1) % fetchConfigs.getProxies().size();
                proxyUrl = fetchConfigs.getProxies().get(offset);
                HttpHandler.caller.set(proxyUrl);
                log.info("proxy url : {} ; url : {}", proxyUrl, uri.toString());
            } else if (Proxy_None.equals(specialProxy)) {
                HttpHandler.caller.set("");
            } else {
                proxyUrl = specialProxy;
            }

            if (StringUtils.isNotBlank(proxyUrl)) {
                String[] infos = proxyUrl.split(":");
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(infos[0], Integer.parseInt(infos[1])));
                log.info("select proxy success. url : {} ; proxy : {}", uri, proxy);
                proxyList = Lists.newArrayList(proxy);
            }

        } catch (Throwable e ) {
            log.error("select proxy fail. url : {} ; err : {}", uri, e);
        }

        return proxyList;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        /* ignore */
    }

}
