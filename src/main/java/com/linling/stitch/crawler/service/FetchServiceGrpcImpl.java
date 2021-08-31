package com.linling.stitch.crawler.service;

import com.google.protobuf.ByteString;
import com.linling.stitch.crawler.common.FetchStatus;
import com.linling.stitch.crawler.dao.HttpHandler;
import com.linling.stitch.crawler.data.RequestEntity;
import com.linling.stitch.crawler.data.ResponseEntity;
import com.linling.stitch.crawler.grpc.protobuf.*;
import com.linling.stitch.crawler.selector.UserAgentSelector;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FetchServiceGrpcImpl extends FetchServiceGrpc.FetchServiceImplBase {

    @Autowired
    private HttpHandler httpHandler;

    @Autowired
    private UserAgentSelector userAgentSelector;

    @Override
    public void fetch(FetchRequest request, StreamObserver<FetchResponse> responseObserver) {
        log.info("[fetch] received request. url : {} ; request : {}", request.getUrl(), request);
        try {
            if (StringUtils.isBlank(request.getUrl())) {
                throw new IllegalArgumentException("url is empty");
            }
            FetchResponse resp = request(request);
            log.info("[fetch] opt success. url : {} ; real url : {} ; fetch status : {} ; http code : {} ; proxy : {} ; cost : {} ; proto : {} ", request.getUrl(), resp.getRealUrl(), resp.getStatus().toString(), resp.getHttpCode(), resp.getProxy(), resp.getCost(), resp.getProto());
            responseObserver.onNext(resp);
            responseObserver.onCompleted();
        } catch (Throwable e) {
            log.error("[fetch] opt fail. url : {} ; err : {}", request.getUrl(), e);
            responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(e.toString())));
        }
    }

    @Override
    public StreamObserver<FetchRequest> fetchMulti(StreamObserver<FetchResponses> responseObserver) {
        return new StreamObserver<>() {
            List<FetchResponse> resps = new ArrayList<>();
            @Override
            public void onNext(FetchRequest request) {
                log.info("[fetchMulti] received request. url : {} ; request : {}", request.getUrl(), request);
                FetchResponse resp = requestWithoutError(request);
                log.info("[fetchMulti] opt success. url : {} ; real url : {} ; fetch status : {} ; http code : {} ; proxy : {} ; cost : {} ; proto : {} ", request.getUrl(), resp.getRealUrl(), resp.getStatus().toString(), resp.getHttpCode(), resp.getProxy(), resp.getCost(), resp.getProto());
                resps.add(resp);
            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(throwable.toString())));
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(FetchResponses.newBuilder().addAllFetchResponses(resps).build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<FetchRequest> asyncFetch(StreamObserver<FetchResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(FetchRequest request) {
                log.info("[asyncFetch] received request. url : {} ; request : {}", request.getUrl(), request);
                FetchResponse resp = requestWithoutError(request);
                log.info("[asyncFetch] opt success. url : {} ; real url : {} ; fetch status : {} ; http code : {} ; proxy : {} ; cost : {} ; proto : {} ", request.getUrl(), resp.getRealUrl(), resp.getStatus().toString(), resp.getHttpCode(), resp.getProxy(), resp.getCost(), resp.getProto());
                responseObserver.onNext(resp);
            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onError(new StatusRuntimeException(Status.ABORTED.withDescription(throwable.toString())));
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }


    private FetchResponse requestWithoutError(FetchRequest request) {
        long startT = System.currentTimeMillis();
        FetchResponse response = null;
        try {
            response = request(request);
        } catch (Throwable e) {
            log.error("request fail. url : {} ; err : {}", request.getUrl(), e);
            response = FetchResponse.newBuilder()
                    .setFetchUrl(request.getUrl())
                    .setCost(System.currentTimeMillis()-startT)
                    .setTs(startT/1000)
                    .setStatus(com.linling.stitch.crawler.grpc.protobuf.FetchStatus.newBuilder().setCode(FetchCode.FETCHED_ERROR).setMsg(e.getMessage()).build())
                    .build();
        }
        return response;
    }

    private FetchResponse request(FetchRequest request) {
        RequestEntity entity = new RequestEntity();
        entity.setUrl(request.getUrl());
        entity.setBody(request.getBody().toByteArray());
        entity.setMethod(request.getMethod());
        entity.setHeader(new HashMap<>(request.getHeaderMap()));
        entity.setTimeout(request.getTimeout());
        entity.setProxy(request.getProxy());

        ResponseEntity reply = httpHandler.request(entity);
        FetchResponse.Builder response = FetchResponse.newBuilder();
        response.setFetchUrl(reply.getFetchUrl())
                .setCost(reply.getCost())
                .setStatus(com.linling.stitch.crawler.grpc.protobuf.FetchStatus.newBuilder().setCodeValue(reply.getStatus().getFetchCode().getCode()).setMsg(Optional.ofNullable(reply.getStatus().getMsg()).filter(StringUtils::isNoneBlank).orElse("")).build());

        if (reply.getStatus().getFetchCode() == FetchStatus.FetchCode.SUCCESS) {
            response.setRealUrl(reply.getRealUrl())
                    .setHttpCode(reply.getHttpCode())
                    .setHttpMsg(Optional.ofNullable(reply.getHttpMsg()).filter(StringUtils::isNoneBlank).orElse(""))
                    .setProto(reply.getProto())
                    .putAllHeader(reply.getHeader())
                    .setBody(ByteString.copyFrom(reply.getBody()))
                    .setTs(reply.getTs())
                    .setProxy(Optional.ofNullable(reply.getProxy()).filter(StringUtils::isNoneBlank).orElse(""));
        }

        return response.build();

    }
}