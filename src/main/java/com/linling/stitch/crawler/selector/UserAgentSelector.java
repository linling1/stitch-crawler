package com.linling.stitch.crawler.selector;

import com.linling.stitch.crawler.configs.FetchConfigs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class UserAgentSelector {

    @Autowired
    private FetchConfigs fetchConfigs;

    private AtomicInteger index = new AtomicInteger(0);

    public String select(String url) {
        int offset = index.addAndGet(1) % fetchConfigs.getUserAgents().size();
        String userAgent = fetchConfigs.getUserAgents().get(offset);
        log.info("url : {} ; userAgent : {}", url, userAgent);
        return userAgent;

    }

}
