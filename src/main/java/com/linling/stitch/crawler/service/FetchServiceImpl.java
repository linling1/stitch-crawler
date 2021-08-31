package com.linling.stitch.crawler.service;

import com.linling.stitch.crawler.dao.HttpHandler;
import com.linling.stitch.crawler.model.FetchReq;
import com.linling.stitch.crawler.model.FetchResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.linling.stitch.crawler.common.ApiConstants.Proxy_None;

@Service
public class FetchServiceImpl {

    @Autowired
    private HttpHandler httpHandler;

    public FetchResp fetch(FetchReq req) {
        FetchResp resp = new FetchResp();
        BeanUtils.copyProperties(httpHandler.request(req), resp);
        return resp;
    }
}
