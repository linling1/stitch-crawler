package com.linling.stitch.crawler.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Map;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestEntity {

    private String url;
    private String method;
    private byte[] body;
    private Map<String, String> header;
    private long timeout;
    private String proxy;

}
