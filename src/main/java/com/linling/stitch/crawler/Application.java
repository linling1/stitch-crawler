package com.linling.stitch.crawler;


import com.linling.stitch.crawler.grpc.server.FetchGrpcServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
    --add-opens java.net.http/jdk.internal.net.http=ALL-UNNAMED -Dspring.profiles.active=prod
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
        FetchGrpcServer grpcServer = configurableApplicationContext.getBean(FetchGrpcServer.class);
        grpcServer.start();
        log.info("Stitch Crawler Application Start...");
    }

}
