# 3-8 使用Filter和Interceptor拦截REST服务

## Spring AOP 简介

* 切片
  * 切入点（注解）
    1. 在哪些方法上起作用
    2. 在什么时候起作用
  * 增强（方法）
    1. 起作用时执行的业务逻辑
    

## RESTful API 的拦截

1. Filter
2. Interceptor
3. ControllerAdvice
4. Aspect
5. Controller


## 正常流的拦截日志

```java
2018-03-19 09:35:37.279  INFO 39197 --- [nio-8080-exec-2] com.imooc.web.filter.TimeFilter          : TimeFilter do start
2018-03-19 09:35:37.282  INFO 39197 --- [nio-8080-exec-2] c.immoc.web.interceptor.TimeInterceptor  : preHandle
2018-03-19 09:35:37.282  INFO 39197 --- [nio-8080-exec-2] c.immoc.web.interceptor.TimeInterceptor  : com.imooc.web.controller.UserController$$EnhancerBySpringCGLIB$$40a99fc0
2018-03-19 09:35:37.282  INFO 39197 --- [nio-8080-exec-2] c.immoc.web.interceptor.TimeInterceptor  : getInfo
2018-03-19 09:35:37.282  INFO 39197 --- [nio-8080-exec-2] com.imooc.web.aspect.TimeAspect          : TimeAspect start
2018-03-19 09:35:37.282  INFO 39197 --- [nio-8080-exec-2] com.imooc.web.aspect.TimeAspect          : args: {1}
2018-03-19 09:35:37.282  INFO 39197 --- [nio-8080-exec-2] com.imooc.web.controller.UserController  : getInfo user_id = 1
2018-03-19 09:35:37.282  INFO 39197 --- [nio-8080-exec-2] com.imooc.web.aspect.TimeAspect          : TimeAspect 耗时：0 毫秒
2018-03-19 09:35:37.282  INFO 39197 --- [nio-8080-exec-2] com.imooc.web.aspect.TimeAspect          : TimeAspect end
2018-03-19 09:35:37.283  INFO 39197 --- [nio-8080-exec-2] c.immoc.web.interceptor.TimeInterceptor  : postHandle
2018-03-19 09:35:37.283  INFO 39197 --- [nio-8080-exec-2] c.immoc.web.interceptor.TimeInterceptor  : TimeInterceptor 耗时: 1 毫秒
2018-03-19 09:35:37.283  INFO 39197 --- [nio-8080-exec-2] c.immoc.web.interceptor.TimeInterceptor  : afterCompletion
2018-03-19 09:35:37.283  INFO 39197 --- [nio-8080-exec-2] c.immoc.web.interceptor.TimeInterceptor  : TimeInterceptor 耗时: 1 毫秒
2018-03-19 09:35:37.283  INFO 39197 --- [nio-8080-exec-2] c.immoc.web.interceptor.TimeInterceptor  : ex is {}
2018-03-19 09:35:37.283  INFO 39197 --- [nio-8080-exec-2] com.imooc.web.filter.TimeFilter          : TimeFilter 耗时：4 毫秒
2018-03-19 09:35:37.283  INFO 39197 --- [nio-8080-exec-2] com.imooc.web.filter.TimeFilter          : TimeFilter do finish
```