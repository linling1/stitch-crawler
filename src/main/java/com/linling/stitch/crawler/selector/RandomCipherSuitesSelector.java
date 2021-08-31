package com.linling.stitch.crawler.selector;


import com.linling.stitch.crawler.configs.FetchConfigs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLParameters;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RandomCipherSuitesSelector extends SSLParameters {

    @Autowired
    private FetchConfigs fetchConfigs;

    /*
        chrome default cipherSuites intersection java support cipherSuites
     */
    private List<String> baseCipherSuites() {
        return Arrays.asList(
                "TLS_AES_128_GCM_SHA256",
                "TLS_AES_256_GCM_SHA384",
//                "TLS_CHACHA20_POLY1305_SHA256",
                "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
//                "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256",
//                "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256",
                "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
                "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
                "TLS_RSA_WITH_AES_128_GCM_SHA256",
                "TLS_RSA_WITH_AES_256_GCM_SHA384",
                "TLS_RSA_WITH_AES_128_CBC_SHA",
                "TLS_RSA_WITH_AES_256_CBC_SHA"
        );
    }

    public String[] select() {
        if (fetchConfigs.getCipherSuites().isEmpty()) {
            return new String[0];
        }
        Random random = new Random(System.nanoTime());
        int size = random.nextInt(fetchConfigs.getCipherSuites().size()/2);
        List<String> ciphers = Arrays.asList(fetchConfigs.getCipherSuites().toArray(new String[0]));
        Collections.shuffle(ciphers);
        List<String> subCiphers = ciphers.subList(0,size*2);
        Set<String> uniqCiphers = new HashSet<>(baseCipherSuites());
        uniqCiphers.addAll(subCiphers);
        log.info("RandomCipherSuitesSelector-select. ciphers : {}", uniqCiphers);
        return uniqCiphers.toArray(new String[0]);
    }

    @Autowired
    public String[] getCipherSuites() {
        return select();
    }

}
