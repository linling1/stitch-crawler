package com.linling.stitch.crawler.grpc.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: fetch.proto")
public final class FetchServiceGrpc {

  private FetchServiceGrpc() {}

  public static final String SERVICE_NAME = "fetch.FetchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<FetchRequest,
          FetchResponse> getFetchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Fetch",
      requestType = FetchRequest.class,
      responseType = FetchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FetchRequest,
          FetchResponse> getFetchMethod() {
    io.grpc.MethodDescriptor<FetchRequest, FetchResponse> getFetchMethod;
    if ((getFetchMethod = FetchServiceGrpc.getFetchMethod) == null) {
      synchronized (FetchServiceGrpc.class) {
        if ((getFetchMethod = FetchServiceGrpc.getFetchMethod) == null) {
          FetchServiceGrpc.getFetchMethod = getFetchMethod = 
              io.grpc.MethodDescriptor.<FetchRequest, FetchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fetch.FetchService", "Fetch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FetchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FetchResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FetchServiceMethodDescriptorSupplier("Fetch"))
                  .build();
          }
        }
     }
     return getFetchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FetchRequest,
          FetchResponses> getFetchMultiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchMulti",
      requestType = FetchRequest.class,
      responseType = FetchResponses.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<FetchRequest,
          FetchResponses> getFetchMultiMethod() {
    io.grpc.MethodDescriptor<FetchRequest, FetchResponses> getFetchMultiMethod;
    if ((getFetchMultiMethod = FetchServiceGrpc.getFetchMultiMethod) == null) {
      synchronized (FetchServiceGrpc.class) {
        if ((getFetchMultiMethod = FetchServiceGrpc.getFetchMultiMethod) == null) {
          FetchServiceGrpc.getFetchMultiMethod = getFetchMultiMethod = 
              io.grpc.MethodDescriptor.<FetchRequest, FetchResponses>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "fetch.FetchService", "FetchMulti"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FetchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FetchResponses.getDefaultInstance()))
                  .setSchemaDescriptor(new FetchServiceMethodDescriptorSupplier("FetchMulti"))
                  .build();
          }
        }
     }
     return getFetchMultiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FetchRequest,
          FetchResponse> getAsyncFetchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AsyncFetch",
      requestType = FetchRequest.class,
      responseType = FetchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<FetchRequest,
          FetchResponse> getAsyncFetchMethod() {
    io.grpc.MethodDescriptor<FetchRequest, FetchResponse> getAsyncFetchMethod;
    if ((getAsyncFetchMethod = FetchServiceGrpc.getAsyncFetchMethod) == null) {
      synchronized (FetchServiceGrpc.class) {
        if ((getAsyncFetchMethod = FetchServiceGrpc.getAsyncFetchMethod) == null) {
          FetchServiceGrpc.getAsyncFetchMethod = getAsyncFetchMethod = 
              io.grpc.MethodDescriptor.<FetchRequest, FetchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "fetch.FetchService", "AsyncFetch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FetchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FetchResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FetchServiceMethodDescriptorSupplier("AsyncFetch"))
                  .build();
          }
        }
     }
     return getAsyncFetchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FetchServiceStub newStub(io.grpc.Channel channel) {
    return new FetchServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FetchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FetchServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FetchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FetchServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FetchServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetch(FetchRequest request,
                      io.grpc.stub.StreamObserver<FetchResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<FetchRequest> fetchMulti(
        io.grpc.stub.StreamObserver<FetchResponses> responseObserver) {
      return asyncUnimplementedStreamingCall(getFetchMultiMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<FetchRequest> asyncFetch(
        io.grpc.stub.StreamObserver<FetchResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAsyncFetchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      FetchRequest,
                      FetchResponse>(
                  this, METHODID_FETCH)))
          .addMethod(
            getFetchMultiMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                      FetchRequest,
                      FetchResponses>(
                  this, METHODID_FETCH_MULTI)))
          .addMethod(
            getAsyncFetchMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                      FetchRequest,
                      FetchResponse>(
                  this, METHODID_ASYNC_FETCH)))
          .build();
    }
  }

  /**
   */
  public static final class FetchServiceStub extends io.grpc.stub.AbstractStub<FetchServiceStub> {
    private FetchServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FetchServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FetchServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FetchServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetch(FetchRequest request,
                      io.grpc.stub.StreamObserver<FetchResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<FetchRequest> fetchMulti(
        io.grpc.stub.StreamObserver<FetchResponses> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getFetchMultiMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<FetchRequest> asyncFetch(
        io.grpc.stub.StreamObserver<FetchResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAsyncFetchMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FetchServiceBlockingStub extends io.grpc.stub.AbstractStub<FetchServiceBlockingStub> {
    private FetchServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FetchServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FetchServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FetchServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public FetchResponse fetch(FetchRequest request) {
      return blockingUnaryCall(
          getChannel(), getFetchMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FetchServiceFutureStub extends io.grpc.stub.AbstractStub<FetchServiceFutureStub> {
    private FetchServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FetchServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FetchServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FetchServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<FetchResponse> fetch(
        FetchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH = 0;
  private static final int METHODID_FETCH_MULTI = 1;
  private static final int METHODID_ASYNC_FETCH = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FetchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FetchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH:
          serviceImpl.fetch((FetchRequest) request,
              (io.grpc.stub.StreamObserver<FetchResponse>) responseObserver);
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
        case METHODID_FETCH_MULTI:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.fetchMulti(
              (io.grpc.stub.StreamObserver<FetchResponses>) responseObserver);
        case METHODID_ASYNC_FETCH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.asyncFetch(
              (io.grpc.stub.StreamObserver<FetchResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FetchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FetchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return FetchProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FetchService");
    }
  }

  private static final class FetchServiceFileDescriptorSupplier
      extends FetchServiceBaseDescriptorSupplier {
    FetchServiceFileDescriptorSupplier() {}
  }

  private static final class FetchServiceMethodDescriptorSupplier
      extends FetchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FetchServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FetchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FetchServiceFileDescriptorSupplier())
              .addMethod(getFetchMethod())
              .addMethod(getFetchMultiMethod())
              .addMethod(getAsyncFetchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
