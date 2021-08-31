package com.linling.stitch.crawler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.linling.stitch.crawler.data.RequestEntity;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchReq extends RequestEntity {

}
