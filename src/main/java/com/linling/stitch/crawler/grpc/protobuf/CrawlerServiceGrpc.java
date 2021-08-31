package com.linling.stitch.crawler.grpc.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: fetch.proto")
public final class CrawlerServiceGrpc {

  private CrawlerServiceGrpc() {}

  public static final String SERVICE_NAME = "crawler.CrawlerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
      com.linling.stitch.crawler.grpc.protobuf.FetchResponse> getFetchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Fetch",
      requestType = com.linling.stitch.crawler.grpc.protobuf.FetchRequest.class,
      responseType = com.linling.stitch.crawler.grpc.protobuf.FetchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
      com.linling.stitch.crawler.grpc.protobuf.FetchResponse> getFetchMethod() {
    io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest, com.linling.stitch.crawler.grpc.protobuf.FetchResponse> getFetchMethod;
    if ((getFetchMethod = CrawlerServiceGrpc.getFetchMethod) == null) {
      synchronized (CrawlerServiceGrpc.class) {
        if ((getFetchMethod = CrawlerServiceGrpc.getFetchMethod) == null) {
          CrawlerServiceGrpc.getFetchMethod = getFetchMethod = 
              io.grpc.MethodDescriptor.<com.linling.stitch.crawler.grpc.protobuf.FetchRequest, com.linling.stitch.crawler.grpc.protobuf.FetchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "crawler.CrawlerService", "Fetch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.linling.stitch.crawler.grpc.protobuf.FetchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.linling.stitch.crawler.grpc.protobuf.FetchResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CrawlerServiceMethodDescriptorSupplier("Fetch"))
                  .build();
          }
        }
     }
     return getFetchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
      com.linling.stitch.crawler.grpc.protobuf.FetchResponses> getMultiFetchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MultiFetch",
      requestType = com.linling.stitch.crawler.grpc.protobuf.FetchRequest.class,
      responseType = com.linling.stitch.crawler.grpc.protobuf.FetchResponses.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
      com.linling.stitch.crawler.grpc.protobuf.FetchResponses> getMultiFetchMethod() {
    io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest, com.linling.stitch.crawler.grpc.protobuf.FetchResponses> getMultiFetchMethod;
    if ((getMultiFetchMethod = CrawlerServiceGrpc.getMultiFetchMethod) == null) {
      synchronized (CrawlerServiceGrpc.class) {
        if ((getMultiFetchMethod = CrawlerServiceGrpc.getMultiFetchMethod) == null) {
          CrawlerServiceGrpc.getMultiFetchMethod = getMultiFetchMethod = 
              io.grpc.MethodDescriptor.<com.linling.stitch.crawler.grpc.protobuf.FetchRequest, com.linling.stitch.crawler.grpc.protobuf.FetchResponses>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "crawler.CrawlerService", "MultiFetch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.linling.stitch.crawler.grpc.protobuf.FetchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.linling.stitch.crawler.grpc.protobuf.FetchResponses.getDefaultInstance()))
                  .setSchemaDescriptor(new CrawlerServiceMethodDescriptorSupplier("MultiFetch"))
                  .build();
          }
        }
     }
     return getMultiFetchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
      com.linling.stitch.crawler.grpc.protobuf.FetchResponse> getAsyncFetchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AsyncFetch",
      requestType = com.linling.stitch.crawler.grpc.protobuf.FetchRequest.class,
      responseType = com.linling.stitch.crawler.grpc.protobuf.FetchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
      com.linling.stitch.crawler.grpc.protobuf.FetchResponse> getAsyncFetchMethod() {
    io.grpc.MethodDescriptor<com.linling.stitch.crawler.grpc.protobuf.FetchRequest, com.linling.stitch.crawler.grpc.protobuf.FetchResponse> getAsyncFetchMethod;
    if ((getAsyncFetchMethod = CrawlerServiceGrpc.getAsyncFetchMethod) == null) {
      synchronized (CrawlerServiceGrpc.class) {
        if ((getAsyncFetchMethod = CrawlerServiceGrpc.getAsyncFetchMethod) == null) {
          CrawlerServiceGrpc.getAsyncFetchMethod = getAsyncFetchMethod = 
              io.grpc.MethodDescriptor.<com.linling.stitch.crawler.grpc.protobuf.FetchRequest, com.linling.stitch.crawler.grpc.protobuf.FetchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "crawler.CrawlerService", "AsyncFetch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.linling.stitch.crawler.grpc.protobuf.FetchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.linling.stitch.crawler.grpc.protobuf.FetchResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CrawlerServiceMethodDescriptorSupplier("AsyncFetch"))
                  .build();
          }
        }
     }
     return getAsyncFetchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CrawlerServiceStub newStub(io.grpc.Channel channel) {
    return new CrawlerServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CrawlerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CrawlerServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CrawlerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CrawlerServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CrawlerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetch(com.linling.stitch.crawler.grpc.protobuf.FetchRequest request,
        io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchRequest> multiFetch(
        io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponses> responseObserver) {
      return asyncUnimplementedStreamingCall(getMultiFetchMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchRequest> asyncFetch(
        io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAsyncFetchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
                com.linling.stitch.crawler.grpc.protobuf.FetchResponse>(
                  this, METHODID_FETCH)))
          .addMethod(
            getMultiFetchMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
                com.linling.stitch.crawler.grpc.protobuf.FetchResponses>(
                  this, METHODID_MULTI_FETCH)))
          .addMethod(
            getAsyncFetchMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.linling.stitch.crawler.grpc.protobuf.FetchRequest,
                com.linling.stitch.crawler.grpc.protobuf.FetchResponse>(
                  this, METHODID_ASYNC_FETCH)))
          .build();
    }
  }

  /**
   */
  public static final class CrawlerServiceStub extends io.grpc.stub.AbstractStub<CrawlerServiceStub> {
    private CrawlerServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CrawlerServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrawlerServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CrawlerServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetch(com.linling.stitch.crawler.grpc.protobuf.FetchRequest request,
        io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchRequest> multiFetch(
        io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponses> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getMultiFetchMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchRequest> asyncFetch(
        io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAsyncFetchMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CrawlerServiceBlockingStub extends io.grpc.stub.AbstractStub<CrawlerServiceBlockingStub> {
    private CrawlerServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CrawlerServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrawlerServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CrawlerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.linling.stitch.crawler.grpc.protobuf.FetchResponse fetch(com.linling.stitch.crawler.grpc.protobuf.FetchRequest request) {
      return blockingUnaryCall(
          getChannel(), getFetchMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CrawlerServiceFutureStub extends io.grpc.stub.AbstractStub<CrawlerServiceFutureStub> {
    private CrawlerServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CrawlerServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrawlerServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CrawlerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.linling.stitch.crawler.grpc.protobuf.FetchResponse> fetch(
        com.linling.stitch.crawler.grpc.protobuf.FetchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH = 0;
  private static final int METHODID_MULTI_FETCH = 1;
  private static final int METHODID_ASYNC_FETCH = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CrawlerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CrawlerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH:
          serviceImpl.fetch((com.linling.stitch.crawler.grpc.protobuf.FetchRequest) request,
              (io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MULTI_FETCH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.multiFetch(
              (io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponses>) responseObserver);
        case METHODID_ASYNC_FETCH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.asyncFetch(
              (io.grpc.stub.StreamObserver<com.linling.stitch.crawler.grpc.protobuf.FetchResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CrawlerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CrawlerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.linling.stitch.crawler.grpc.protobuf.CrawlerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CrawlerService");
    }
  }

  private static final class CrawlerServiceFileDescriptorSupplier
      extends CrawlerServiceBaseDescriptorSupplier {
    CrawlerServiceFileDescriptorSupplier() {}
  }

  private static final class CrawlerServiceMethodDescriptorSupplier
      extends CrawlerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CrawlerServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CrawlerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CrawlerServiceFileDescriptorSupplier())
              .addMethod(getFetchMethod())
              .addMethod(getMultiFetchMethod())
              .addMethod(getAsyncFetchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
