package com.linling.stitch.crawler.configs;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@ConfigurationProperties("fetch")
@Data
public class FetchConfigs {

    private List<String> proxies;

    private Long timeout;

    private List<String> userAgents;

    private List<String> cipherSuites;

    private boolean proxyActive;

    private boolean tlsTrustAllCerts;

    private boolean dynamicCipherSuites;


}
