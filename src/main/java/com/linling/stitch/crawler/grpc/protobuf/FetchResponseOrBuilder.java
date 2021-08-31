// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fetch.proto

package com.linling.stitch.crawler.grpc.protobuf;

public interface FetchResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:crawler.FetchResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string real_url = 1;</code>
   */
  java.lang.String getRealUrl();
  /**
   * <code>string real_url = 1;</code>
   */
  com.google.protobuf.ByteString
      getRealUrlBytes();

  /**
   * <code>int32 http_code = 2;</code>
   */
  int getHttpCode();

  /**
   * <code>string http_msg = 3;</code>
   */
  java.lang.String getHttpMsg();
  /**
   * <code>string http_msg = 3;</code>
   */
  com.google.protobuf.ByteString
      getHttpMsgBytes();

  /**
   * <code>map&lt;string, string&gt; header = 4;</code>
   */
  int getHeaderCount();
  /**
   * <code>map&lt;string, string&gt; header = 4;</code>
   */
  boolean containsHeader(
      java.lang.String key);
  /**
   * Use {@link #getHeaderMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, java.lang.String>
  getHeader();
  /**
   * <code>map&lt;string, string&gt; header = 4;</code>
   */
  java.util.Map<java.lang.String, java.lang.String>
  getHeaderMap();
  /**
   * <code>map&lt;string, string&gt; header = 4;</code>
   */

  java.lang.String getHeaderOrDefault(
      java.lang.String key,
      java.lang.String defaultValue);
  /**
   * <code>map&lt;string, string&gt; header = 4;</code>
   */

  java.lang.String getHeaderOrThrow(
      java.lang.String key);

  /**
   * <code>string proto = 5;</code>
   */
  java.lang.String getProto();
  /**
   * <code>string proto = 5;</code>
   */
  com.google.protobuf.ByteString
      getProtoBytes();

  /**
   * <code>bytes body = 6;</code>
   */
  com.google.protobuf.ByteString getBody();

  /**
   * <code>int64 cost = 7;</code>
   */
  long getCost();

  /**
   * <code>int64 ts = 8;</code>
   */
  long getTs();

  /**
   * <code>.crawler.FetchStatus status = 9;</code>
   */
  boolean hasStatus();
  /**
   * <code>.crawler.FetchStatus status = 9;</code>
   */
  com.linling.stitch.crawler.grpc.protobuf.FetchStatus getStatus();
  /**
   * <code>.crawler.FetchStatus status = 9;</code>
   */
  com.linling.stitch.crawler.grpc.protobuf.FetchStatusOrBuilder getStatusOrBuilder();

  /**
   * <code>string proxy = 10;</code>
   */
  java.lang.String getProxy();
  /**
   * <code>string proxy = 10;</code>
   */
  com.google.protobuf.ByteString
      getProxyBytes();

  /**
   * <code>string fetch_url = 11;</code>
   */
  java.lang.String getFetchUrl();
  /**
   * <code>string fetch_url = 11;</code>
   */
  com.google.protobuf.ByteString
      getFetchUrlBytes();
}
