package com.linling.stitch.crawler.grpc.server;


import com.linling.stitch.crawler.service.FetchServiceGrpcImpl;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Objects;
import java.util.Optional;


@Component("FetchGrpcServer")
@Slf4j
public class FetchGrpcServer {

    private Server server;

    @Value("${grpc.server.port}")
    private int port;

    @Value("${grpc.server.maxInboundMessageSize}")
    private int maxSize;

    @Autowired
    private FetchServiceGrpcImpl fetchServiceGrpc;

    @PostConstruct
    public void init() {
        server = NettyServerBuilder
                .forAddress(new InetSocketAddress("0.0.0.0", port))
                .addService(fetchServiceGrpc)
                .maxInboundMessageSize(maxSize)
//                .keepAliveTime(1, TimeUnit.MILLISECONDS)
//                .keepAliveTimeout(1,TimeUnit.MILLISECONDS)
//                .permitKeepAliveTime(1,TimeUnit.NANOSECONDS)
//                .permitKeepAliveWithoutCalls(true)
                .build();
    }

    public void start() throws IOException {
        server.start();
    }

    @PreDestroy
    public void stop() {
        Optional.ofNullable(server).ifPresent(Server::shutdown);
    }

}
