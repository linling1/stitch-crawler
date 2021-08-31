package com.linling.stitch.crawler.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linling.stitch.crawler.exception.FetchException;
import com.linling.stitch.crawler.model.FetchApiRet;
import com.linling.stitch.crawler.model.FetchReq;
import com.linling.stitch.crawler.model.FetchResp;
import com.linling.stitch.crawler.service.FetchServiceImpl;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.linling.stitch.crawler.common.ApiConstants.API_RET_CODE_SUCCESS;
import static com.linling.stitch.crawler.common.ApiConstants.API_RET_STATUS_SUCCESS;

@RestController
@CrossOrigin("*")
@Slf4j
public class FetchController {

    public final static ThreadLocal<String> customProxy = new ThreadLocal<>();

    public static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private FetchServiceImpl fetchService;

    @PostMapping("/fetch/url")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request Param!"),
            @ApiResponse(code = 404, message = "Not Found!"),
            @ApiResponse(code = 500, message = "Server error!") })
    @ResponseStatus(value = HttpStatus.OK)
    public FetchApiRet fetch(@RequestBody FetchReq req) throws Exception {
        FetchApiRet ret = new FetchApiRet();
        paramVerify(req.getUrl(), "url");
        FetchResp data = fetchService.fetch(req);
        ret.setRet(data);
        ret.setCode(API_RET_CODE_SUCCESS);
        ret.setStatus(API_RET_STATUS_SUCCESS);
        return ret;
    }

    private void paramVerify(Object param, String filed) throws FetchException {
        if (Objects.isNull(param)) {
            throw new FetchException(filed + " param is empty.");
        }
        if (param instanceof String && StringUtils.isBlank((String)param)) {
            throw new FetchException(filed + " param invalid. " + filed + " : " + param);
        }
        if (param instanceof List && ((List)param).isEmpty()) {
            throw new FetchException(filed + " param invalid. " + filed + " : " + param);
        }
    }
}
