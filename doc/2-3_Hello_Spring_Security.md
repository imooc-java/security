# 2-3 Hello Spring Security

## Jar 包启动命名

```java
java -jar demo.jar
```

## 问题记录

* Cannot determine embedded database driver class for database type NONE

  原因是没有配置数据库

* Establishing SSL connection without server's identity verification is not recommended. According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'. You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.

  jdbc url 后面增加参数 useSSL=false 即可

  ```properties
  spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  spring.datasource.url=jdbc:mysql://127.0.0.1:3306/imooc-demo?useUnicode=true&characterEncoding=UTF-8&useSSL=false
  spring.datasource.username=root
  spring.datasource.password=123456
  ```
  
* No Spring Session store is configured: set the 'spring.session.store-type' property
  
  ```properties
  spring.session.store-type=none
  ```

* org.springframework.data.redis.RedisConnectionFailureException: Cannot get Jedis connection; nested exception is redis.clients.jedis.exceptions.JedisConnectionException: Could not get a resource from the pool
  
  需要安装并配置 redis 服务器参数
  
  ```properties
  spring.redis.host=127.0.0.1
  spring.redis.port=6379
  ```

* 需要进行身份验证

  ```properties
  security.basic.enabled=false
  ```
