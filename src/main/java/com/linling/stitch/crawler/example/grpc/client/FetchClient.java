package com.linling.stitch.crawler.example.grpc.client;

import com.linling.stitch.crawler.grpc.protobuf.FetchRequest;
import com.linling.stitch.crawler.grpc.protobuf.FetchResponse;
import com.linling.stitch.crawler.grpc.protobuf.FetchResponses;
import com.linling.stitch.crawler.grpc.protobuf.FetchServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FetchClient {

    static {
        Logger.getLogger("io.grpc").setLevel(Level.OFF);
        Logger.getLogger("io.netty").setLevel(Level.OFF);

    }


    private List<String> urls;
    private ManagedChannel channel;
    private FetchServiceGrpc.FetchServiceBlockingStub sub;
    private FetchServiceGrpc.FetchServiceStub asub;
    CyclicBarrier startBarrier;
    CountDownLatch endLatch;

    public FetchClient() {
        urls = Arrays.asList(
                "https://www.yidianzixun.com/article/0VllPf7g"
//                "https://ja3er.com/json"
        );
        channel = ManagedChannelBuilder.forAddress("127.0.0.1", 60051).defaultLoadBalancingPolicy("round_robin").usePlaintext().build();
        sub = FetchServiceGrpc.newBlockingStub(channel);
        asub = FetchServiceGrpc.newStub(channel);
        startBarrier = new CyclicBarrier(3);
        endLatch = new CountDownLatch(3);
    }

    public static void main(String[] args) throws InterruptedException {
        FetchClient fetchClient = new FetchClient();
        fetchClient.fetch(false);
    }


    @FunctionalInterface
    private interface IgnoreReturnAndErr {

        int exec() throws InterruptedException, BrokenBarrierException;

        static void of(IgnoreReturnAndErr f) {
            try {
                f.exec();
            } catch (Throwable e) {

            }

        }
    }

    private void all() throws InterruptedException {

        new Thread(()->fetch(true)).start();
        new Thread(()->multiFetch(true)).start();
        new Thread(()->asyncFetch(true)).start();

        endLatch.await();
    }

    private void fetch(boolean flag) {
        System.out.println("============= fetch ===============");
        try {
            Optional.of(flag).filter(f->f).ifPresent(f -> IgnoreReturnAndErr.of(startBarrier::await));
            for (String url : urls) {
                System.out.println("[fetch-request] ##### url : " + url);
                FetchResponse resp = sub.fetch(FetchRequest.newBuilder().setUrl(url).setProxy("172.31.39.24:3128")
//                        .putHeader(User_Agent, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.1 Safari/605.1.15")
//                        .putHeader("Accept-Language", "en-us")
//                        .putHeader("Accept-Encoding", "gzip,deflate,br")
                        .build());
                System.out.println("[fetch-response] ===== url : " + url);
                System.out.println("[fetch-response] ===== http_code : " + resp.getHttpCode());
                System.out.println(resp);
            }
        } catch (Throwable e) {
            System.out.println(e.getClass());
            System.out.println("[fetch-response] +++++ fetch error. " + e.getMessage());
        }
        Optional.of(flag).ifPresent(f -> endLatch.countDown());
    }

    private void multiFetch(boolean flag) {
        try {
            System.out.println("============= multiFetch ===============");
            StreamObserver<FetchRequest> requestObserver = asub.fetchMulti(new StreamObserver<FetchResponses>() {
                @Override
                public void onNext(FetchResponses fetchResponses) {

                    for (FetchResponse resp : fetchResponses.getFetchResponsesList()) {
                        System.out.println("[multiFetch-response] ===== url : " + resp.getFetchUrl());
                        System.out.println(resp);
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("[multiFetch-response] +++++ multiFetch error. " + throwable.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("[multiFetch-response] ##### multiFetch Done #####");
                    Optional.of(flag).ifPresent(f -> endLatch.countDown());
                }
            });

            Optional.of(flag).filter(f->f).ifPresent(f -> IgnoreReturnAndErr.of(startBarrier::await));
            for (String url : urls) {
                System.out.println("[multiFetch-request] ##### url : " + url);
                requestObserver.onNext(FetchRequest.newBuilder().setUrl(url).build());
            }
            requestObserver.onCompleted();
            System.out.println("[multiFetch-request] ===== multiFetch Done =====");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void asyncFetch(boolean flag) {
        try {
            System.out.println("============= asyncFetch ===============");
            StreamObserver<FetchRequest> requestObserver = asub.asyncFetch(new StreamObserver<FetchResponse>() {
                @Override
                public void onNext(FetchResponse fetchResponse) {
                    System.out.println("[asyncFetch-response] ===== url : " + fetchResponse.getFetchUrl());
                    System.out.println(fetchResponse);
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("[asyncFetch-response] +++++ asyncFetch error. " + throwable.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("[asyncFetch-response] ##### asyncFetch Done #####");
                    Optional.of(flag).ifPresent(f -> endLatch.countDown());
                }
            });

            Optional.of(flag).filter(f->f).ifPresent(f -> IgnoreReturnAndErr.of(startBarrier::await));
            for (String url : urls) {
                System.out.println("[asyncFetch-request] ##### url : " + url);
                requestObserver.onNext(FetchRequest.newBuilder().setUrl(url).build());
            }
            requestObserver.onCompleted();
            System.out.println("[asyncFetch-request] ===== asyncFetch Done =====");
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
