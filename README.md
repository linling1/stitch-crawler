# stitch-crawler

爬虫系统中的爬取模块。

基于 openjdk11.0.11 自带的net包实现的 HTTP/1.1 和 HTTP/2 的网络请求，获取网页静态页面内容。

### 编译并启动

~~~
mvn clean  package spring-boot:repackage
cd target
java --add-opens java.net.http/jdk.internal.net.http=ALL-UNNAMED -Dspring.profiles.active=prod -jar stitch-crawler-1.0.0.jar
~~~

##### 服务提供模式

* api
  * swagger url : `http://127.0.0.1:22000/stitch-crawler/swagger-ui/index.html`
  * request url : `http://127.0.0.1:22000/stitch-crawler/fetch/url`
  * 请求类型：POST
  * 参数
  
  | 参数 | 类型 | 描述 |
  |---|---|---|
  | url | string | 必填；待爬取url  |
  | header | map<string,string> | 请求头；一个 key 有多个 value 的使用',' 进行分割 |
  | method | string | 请求类型；默认为"GET" |
  | proxy | string | 代理host，当'proxyActive'为true时有效；格式为：xxx.xxx.xxx.xxx:port; 如，127.0.0.1:1087 |
  | timeout | int | 超时时间，单位：秒；默认为3分钟 |
  | body | bytes | 请求体 |    
  
* grpc
  * host : `127.0.0.1:60051`
  * 请求参数雷同与api

### 爬取相关配置

~~~
fetch:
  // user-agent pool，随机使用；多个 user-agent 可以一定程度上解决反爬识别。
  userAgents:
    - "Mozilla/5.0 (compatible; Bingbot/2.0; +http://www.bing.com/bingbot.htm)"
    - "Mozilla/5.0 (compatible; Yahoo! Slurp; http://help.yahoo.com/help/us/ysearch/slurp)"
    - "DuckDuckBot/1.0; (+http://duckduckgo.com/duckduckbot.html)"
    - "Mozilla/5.0 (compatible; Konqueror/3.5; Linux) KHTML/3.5.5 (like Gecko) (Exabot-Thumbnails)"
    - "ia_archiver (+http://www.alexa.com/site/help/webmasters; crawler@alexa.com)"
  
  // 默认超时时间 3 分钟
  timeout : 180

  // 是否使用代理
  proxyActive: true

  // 是否信任所有的证书，如果为true，当证书无法识别时也能正常请求，否则会返回X509相关错误.
  tlsTrustAllCerts: true

  // 是否使用动态 cipher suites；动态 cipher suites 能一定程度上解决 ja3 指纹进行的反爬识别。
  dynamicCipherSuites: false

  // java 支持的所有 cipher suites
  cipherSuites:
    - "TLS_AES_128_GCM_SHA256"
    - "TLS_AES_256_GCM_SHA384"
    - "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384"
    - "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256"
    - "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384"
    - "TLS_RSA_WITH_AES_256_GCM_SHA384"
    - "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384"
    - "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384"
    - "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384"
    - "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"
    - "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"
    - "TLS_RSA_WITH_AES_128_GCM_SHA256"
    - "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256"
    - "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256"
    - "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256"
    - "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256"
    - "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384"
    - "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384"
    - "TLS_RSA_WITH_AES_256_CBC_SHA256"
    - "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384"
    - "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384"
    - "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256"
    - "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256"
    - "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA"
    - "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"
    - "TLS_RSA_WITH_AES_256_CBC_SHA"
    - "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA"
    - "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA"
    - "TLS_DHE_RSA_WITH_AES_256_CBC_SHA"
    - "TLS_DHE_DSS_WITH_AES_256_CBC_SHA"
    - "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256"
    - "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256"
    - "TLS_RSA_WITH_AES_128_CBC_SHA256"
    - "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256"
    - "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256"
    - "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256"
    - "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256"
    - "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA"
    - "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA"
    - "TLS_RSA_WITH_AES_128_CBC_SHA"
    - "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA"
    - "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA"
    - "TLS_DHE_RSA_WITH_AES_128_CBC_SHA"
    - "TLS_DHE_DSS_WITH_AES_128_CBC_SHA"
    - "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"

  // 当 proxyActive 时，可以使用代理池中的代理发起请求，也可以通过参数执行指定代理。
  proxies:
    - 127.0.0.1:1087
~~~

### example

~~~
    example
      |___ grpc
            |___ client
                    |___ FetchClient : grpc client 使用示例
~~~
