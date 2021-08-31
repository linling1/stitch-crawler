package com.linling.stitch.crawler;

import com.linling.stitch.crawler.protobuf.FetchResponse;
import com.linling.stitch.crawler.protobuf.FetchServiceGrpc;
import com.linling.stitch.crawler.protobuf.FetchRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class FetchClient {

    public static void main(String[] args) {

        try {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1", 60051).usePlaintext().build();

            FetchServiceGrpc.FetchServiceBlockingStub sub = FetchServiceGrpc.newBlockingStub(channel);
            FetchRequest req = FetchRequest.newBuilder().setUrl("https://www.sbaaaaaaaaaaaaaaaaaaa.com").build();
            FetchResponse resp = sub.fetch(req);
            System.out.println(resp);
        } catch (Throwable e) {
            System.out.println(e.toString());
        }

    }

}
