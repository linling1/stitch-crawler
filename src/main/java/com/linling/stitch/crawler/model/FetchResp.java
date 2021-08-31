package com.linling.stitch.crawler.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.linling.stitch.crawler.data.ResponseEntity;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchResp extends ResponseEntity {
}
