package com.linling.stitch.crawler.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.linling.stitch.crawler.common.FetchStatus;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseEntity {

    private String realUrl;
    private int httpCode;
    private String httpMsg;
    private Map<String, String> header;
    private String proto;
    private byte[] body;
    private long cost;
    private long ts;
    private FetchStatus status;
    private String proxy;
    private String fetchUrl;
    private RequestEntity requestEntity;

}
