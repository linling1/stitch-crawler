// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fetch.proto

package com.linling.stitch.crawler.grpc.protobuf;

/**
 * Protobuf type {@code crawler.FetchRequest}
 */
public  final class FetchRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:crawler.FetchRequest)
    FetchRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FetchRequest.newBuilder() to construct.
  private FetchRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FetchRequest() {
    url_ = "";
    proxy_ = "";
    body_ = com.google.protobuf.ByteString.EMPTY;
    method_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FetchRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            url_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            proxy_ = s;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) != 0)) {
              header_ = com.google.protobuf.MapField.newMapField(
                  HeaderDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000004;
            }
            com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
            header__ = input.readMessage(
                HeaderDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            header_.getMutableMap().put(
                header__.getKey(), header__.getValue());
            break;
          }
          case 34: {

            body_ = input.readBytes();
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            method_ = s;
            break;
          }
          case 48: {

            timeout_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.linling.stitch.crawler.grpc.protobuf.CrawlerProto.internal_static_crawler_FetchRequest_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 3:
        return internalGetHeader();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.linling.stitch.crawler.grpc.protobuf.CrawlerProto.internal_static_crawler_FetchRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.linling.stitch.crawler.grpc.protobuf.FetchRequest.class, com.linling.stitch.crawler.grpc.protobuf.FetchRequest.Builder.class);
  }

  private int bitField0_;
  public static final int URL_FIELD_NUMBER = 1;
  private volatile java.lang.Object url_;
  /**
   * <code>string url = 1;</code>
   */
  public java.lang.String getUrl() {
    java.lang.Object ref = url_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      url_ = s;
      return s;
    }
  }
  /**
   * <code>string url = 1;</code>
   */
  public com.google.protobuf.ByteString
      getUrlBytes() {
    java.lang.Object ref = url_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      url_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PROXY_FIELD_NUMBER = 2;
  private volatile java.lang.Object proxy_;
  /**
   * <code>string proxy = 2;</code>
   */
  public java.lang.String getProxy() {
    java.lang.Object ref = proxy_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      proxy_ = s;
      return s;
    }
  }
  /**
   * <code>string proxy = 2;</code>
   */
  public com.google.protobuf.ByteString
      getProxyBytes() {
    java.lang.Object ref = proxy_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      proxy_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HEADER_FIELD_NUMBER = 3;
  private static final class HeaderDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, java.lang.String> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, java.lang.String>newDefaultInstance(
                com.linling.stitch.crawler.grpc.protobuf.CrawlerProto.internal_static_crawler_FetchRequest_HeaderEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      java.lang.String, java.lang.String> header_;
  private com.google.protobuf.MapField<java.lang.String, java.lang.String>
  internalGetHeader() {
    if (header_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          HeaderDefaultEntryHolder.defaultEntry);
    }
    return header_;
  }

  public int getHeaderCount() {
    return internalGetHeader().getMap().size();
  }
  /**
   * <code>map&lt;string, string&gt; header = 3;</code>
   */

  public boolean containsHeader(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    return internalGetHeader().getMap().containsKey(key);
  }
  /**
   * Use {@link #getHeaderMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, java.lang.String> getHeader() {
    return getHeaderMap();
  }
  /**
   * <code>map&lt;string, string&gt; header = 3;</code>
   */

  public java.util.Map<java.lang.String, java.lang.String> getHeaderMap() {
    return internalGetHeader().getMap();
  }
  /**
   * <code>map&lt;string, string&gt; header = 3;</code>
   */

  public java.lang.String getHeaderOrDefault(
      java.lang.String key,
      java.lang.String defaultValue) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetHeader().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, string&gt; header = 3;</code>
   */

  public java.lang.String getHeaderOrThrow(
      java.lang.String key) {
    if (key == null) { throw new java.lang.NullPointerException(); }
    java.util.Map<java.lang.String, java.lang.String> map =
        internalGetHeader().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  public static final int BODY_FIELD_NUMBER = 4;
  private com.google.protobuf.ByteString body_;
  /**
   * <code>bytes body = 4;</code>
   */
  public com.google.protobuf.ByteString getBody() {
    return body_;
  }

  public static final int METHOD_FIELD_NUMBER = 5;
  private volatile java.lang.Object method_;
  /**
   * <code>string method = 5;</code>
   */
  public java.lang.String getMethod() {
    java.lang.Object ref = method_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      method_ = s;
      return s;
    }
  }
  /**
   * <code>string method = 5;</code>
   */
  public com.google.protobuf.ByteString
      getMethodBytes() {
    java.lang.Object ref = method_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      method_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIMEOUT_FIELD_NUMBER = 6;
  private long timeout_;
  /**
   * <code>int64 timeout = 6;</code>
   */
  public long getTimeout() {
    return timeout_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getUrlBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, url_);
    }
    if (!getProxyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, proxy_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetHeader(),
        HeaderDefaultEntryHolder.defaultEntry,
        3);
    if (!body_.isEmpty()) {
      output.writeBytes(4, body_);
    }
    if (!getMethodBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, method_);
    }
    if (timeout_ != 0L) {
      output.writeInt64(6, timeout_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUrlBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, url_);
    }
    if (!getProxyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, proxy_);
    }
    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry
         : internalGetHeader().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, java.lang.String>
      header__ = HeaderDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, header__);
    }
    if (!body_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(4, body_);
    }
    if (!getMethodBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, method_);
    }
    if (timeout_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, timeout_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.linling.stitch.crawler.grpc.protobuf.FetchRequest)) {
      return super.equals(obj);
    }
    com.linling.stitch.crawler.grpc.protobuf.FetchRequest other = (com.linling.stitch.crawler.grpc.protobuf.FetchRequest) obj;

    if (!getUrl()
        .equals(other.getUrl())) return false;
    if (!getProxy()
        .equals(other.getProxy())) return false;
    if (!internalGetHeader().equals(
        other.internalGetHeader())) return false;
    if (!getBody()
        .equals(other.getBody())) return false;
    if (!getMethod()
        .equals(other.getMethod())) return false;
    if (getTimeout()
        != other.getTimeout()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + URL_FIELD_NUMBER;
    hash = (53 * hash) + getUrl().hashCode();
    hash = (37 * hash) + PROXY_FIELD_NUMBER;
    hash = (53 * hash) + getProxy().hashCode();
    if (!internalGetHeader().getMap().isEmpty()) {
      hash = (37 * hash) + HEADER_FIELD_NUMBER;
      hash = (53 * hash) + internalGetHeader().hashCode();
    }
    hash = (37 * hash) + BODY_FIELD_NUMBER;
    hash = (53 * hash) + getBody().hashCode();
    hash = (37 * hash) + METHOD_FIELD_NUMBER;
    hash = (53 * hash) + getMethod().hashCode();
    hash = (37 * hash) + TIMEOUT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTimeout());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.linling.stitch.crawler.grpc.protobuf.FetchRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code crawler.FetchRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:crawler.FetchRequest)
      com.linling.stitch.crawler.grpc.protobuf.FetchRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.linling.stitch.crawler.grpc.protobuf.CrawlerProto.internal_static_crawler_FetchRequest_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetHeader();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 3:
          return internalGetMutableHeader();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.linling.stitch.crawler.grpc.protobuf.CrawlerProto.internal_static_crawler_FetchRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.linling.stitch.crawler.grpc.protobuf.FetchRequest.class, com.linling.stitch.crawler.grpc.protobuf.FetchRequest.Builder.class);
    }

    // Construct using com.linling.stitch.crawler.grpc.protobuf.FetchRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      url_ = "";

      proxy_ = "";

      internalGetMutableHeader().clear();
      body_ = com.google.protobuf.ByteString.EMPTY;

      method_ = "";

      timeout_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.linling.stitch.crawler.grpc.protobuf.CrawlerProto.internal_static_crawler_FetchRequest_descriptor;
    }

    @java.lang.Override
    public com.linling.stitch.crawler.grpc.protobuf.FetchRequest getDefaultInstanceForType() {
      return com.linling.stitch.crawler.grpc.protobuf.FetchRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.linling.stitch.crawler.grpc.protobuf.FetchRequest build() {
      com.linling.stitch.crawler.grpc.protobuf.FetchRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.linling.stitch.crawler.grpc.protobuf.FetchRequest buildPartial() {
      com.linling.stitch.crawler.grpc.protobuf.FetchRequest result = new com.linling.stitch.crawler.grpc.protobuf.FetchRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.url_ = url_;
      result.proxy_ = proxy_;
      result.header_ = internalGetHeader();
      result.header_.makeImmutable();
      result.body_ = body_;
      result.method_ = method_;
      result.timeout_ = timeout_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.linling.stitch.crawler.grpc.protobuf.FetchRequest) {
        return mergeFrom((com.linling.stitch.crawler.grpc.protobuf.FetchRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.linling.stitch.crawler.grpc.protobuf.FetchRequest other) {
      if (other == com.linling.stitch.crawler.grpc.protobuf.FetchRequest.getDefaultInstance()) return this;
      if (!other.getUrl().isEmpty()) {
        url_ = other.url_;
        onChanged();
      }
      if (!other.getProxy().isEmpty()) {
        proxy_ = other.proxy_;
        onChanged();
      }
      internalGetMutableHeader().mergeFrom(
          other.internalGetHeader());
      if (other.getBody() != com.google.protobuf.ByteString.EMPTY) {
        setBody(other.getBody());
      }
      if (!other.getMethod().isEmpty()) {
        method_ = other.method_;
        onChanged();
      }
      if (other.getTimeout() != 0L) {
        setTimeout(other.getTimeout());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.linling.stitch.crawler.grpc.protobuf.FetchRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.linling.stitch.crawler.grpc.protobuf.FetchRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object url_ = "";
    /**
     * <code>string url = 1;</code>
     */
    public java.lang.String getUrl() {
      java.lang.Object ref = url_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        url_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string url = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUrlBytes() {
      java.lang.Object ref = url_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        url_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string url = 1;</code>
     */
    public Builder setUrl(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      url_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string url = 1;</code>
     */
    public Builder clearUrl() {
      
      url_ = getDefaultInstance().getUrl();
      onChanged();
      return this;
    }
    /**
     * <code>string url = 1;</code>
     */
    public Builder setUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      url_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object proxy_ = "";
    /**
     * <code>string proxy = 2;</code>
     */
    public java.lang.String getProxy() {
      java.lang.Object ref = proxy_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        proxy_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string proxy = 2;</code>
     */
    public com.google.protobuf.ByteString
        getProxyBytes() {
      java.lang.Object ref = proxy_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        proxy_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string proxy = 2;</code>
     */
    public Builder setProxy(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      proxy_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string proxy = 2;</code>
     */
    public Builder clearProxy() {
      
      proxy_ = getDefaultInstance().getProxy();
      onChanged();
      return this;
    }
    /**
     * <code>string proxy = 2;</code>
     */
    public Builder setProxyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      proxy_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, java.lang.String> header_;
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetHeader() {
      if (header_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            HeaderDefaultEntryHolder.defaultEntry);
      }
      return header_;
    }
    private com.google.protobuf.MapField<java.lang.String, java.lang.String>
    internalGetMutableHeader() {
      onChanged();;
      if (header_ == null) {
        header_ = com.google.protobuf.MapField.newMapField(
            HeaderDefaultEntryHolder.defaultEntry);
      }
      if (!header_.isMutable()) {
        header_ = header_.copy();
      }
      return header_;
    }

    public int getHeaderCount() {
      return internalGetHeader().getMap().size();
    }
    /**
     * <code>map&lt;string, string&gt; header = 3;</code>
     */

    public boolean containsHeader(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      return internalGetHeader().getMap().containsKey(key);
    }
    /**
     * Use {@link #getHeaderMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String> getHeader() {
      return getHeaderMap();
    }
    /**
     * <code>map&lt;string, string&gt; header = 3;</code>
     */

    public java.util.Map<java.lang.String, java.lang.String> getHeaderMap() {
      return internalGetHeader().getMap();
    }
    /**
     * <code>map&lt;string, string&gt; header = 3;</code>
     */

    public java.lang.String getHeaderOrDefault(
        java.lang.String key,
        java.lang.String defaultValue) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetHeader().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, string&gt; header = 3;</code>
     */

    public java.lang.String getHeaderOrThrow(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      java.util.Map<java.lang.String, java.lang.String> map =
          internalGetHeader().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearHeader() {
      internalGetMutableHeader().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; header = 3;</code>
     */

    public Builder removeHeader(
        java.lang.String key) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableHeader().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, java.lang.String>
    getMutableHeader() {
      return internalGetMutableHeader().getMutableMap();
    }
    /**
     * <code>map&lt;string, string&gt; header = 3;</code>
     */
    public Builder putHeader(
        java.lang.String key,
        java.lang.String value) {
      if (key == null) { throw new java.lang.NullPointerException(); }
      if (value == null) { throw new java.lang.NullPointerException(); }
      internalGetMutableHeader().getMutableMap()
          .put(key, value);
      return this;
    }
    /**
     * <code>map&lt;string, string&gt; header = 3;</code>
     */

    public Builder putAllHeader(
        java.util.Map<java.lang.String, java.lang.String> values) {
      internalGetMutableHeader().getMutableMap()
          .putAll(values);
      return this;
    }

    private com.google.protobuf.ByteString body_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes body = 4;</code>
     */
    public com.google.protobuf.ByteString getBody() {
      return body_;
    }
    /**
     * <code>bytes body = 4;</code>
     */
    public Builder setBody(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      body_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes body = 4;</code>
     */
    public Builder clearBody() {
      
      body_ = getDefaultInstance().getBody();
      onChanged();
      return this;
    }

    private java.lang.Object method_ = "";
    /**
     * <code>string method = 5;</code>
     */
    public java.lang.String getMethod() {
      java.lang.Object ref = method_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        method_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string method = 5;</code>
     */
    public com.google.protobuf.ByteString
        getMethodBytes() {
      java.lang.Object ref = method_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        method_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string method = 5;</code>
     */
    public Builder setMethod(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      method_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string method = 5;</code>
     */
    public Builder clearMethod() {
      
      method_ = getDefaultInstance().getMethod();
      onChanged();
      return this;
    }
    /**
     * <code>string method = 5;</code>
     */
    public Builder setMethodBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      method_ = value;
      onChanged();
      return this;
    }

    private long timeout_ ;
    /**
     * <code>int64 timeout = 6;</code>
     */
    public long getTimeout() {
      return timeout_;
    }
    /**
     * <code>int64 timeout = 6;</code>
     */
    public Builder setTimeout(long value) {
      
      timeout_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 timeout = 6;</code>
     */
    public Builder clearTimeout() {
      
      timeout_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:crawler.FetchRequest)
  }

  // @@protoc_insertion_point(class_scope:crawler.FetchRequest)
  private static final com.linling.stitch.crawler.grpc.protobuf.FetchRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.linling.stitch.crawler.grpc.protobuf.FetchRequest();
  }

  public static com.linling.stitch.crawler.grpc.protobuf.FetchRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FetchRequest>
      PARSER = new com.google.protobuf.AbstractParser<FetchRequest>() {
    @java.lang.Override
    public FetchRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FetchRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FetchRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FetchRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.linling.stitch.crawler.grpc.protobuf.FetchRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
