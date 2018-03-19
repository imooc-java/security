
*本来是 fork 了 老师的源码的(https://github.com/jojozhai/security)*
*跟着学了两章后，发现还是少了点感觉，干脆自己重新码一遍吧 😁*

小目标

* IDEA 构建
* 使用最新的 Spring 版本

# Spring Security 开发安全的REST服务

视频来源： http://coding.imooc.com/class/134.html

视频作者：[JoJo](http://www.imooc.com/t/3554172)

![jojo](./doc/img/jojo.jpg)

# 章节目录和总结文档

## 第1章 课程导学

* [x] [1-1 导学](./doc/1-1_导学.md)

## 第2章 开始开发

* [x] [2-1 开发环境安装](./doc/2-1_开发环境安装.md)
* [x] [2-2 代码结构介绍](./doc/2-2_代码结构介绍.md)
* [x] [2-3 Hello Spring Security](./doc/2-3_Hello_Spring_Security.md)

## 第3章 使用Spring MVC开发RESTful API

* [x] [3-1 Restful简介](./doc/3-1_Restful简介.md)
* [x] [3-2 查询请求](./doc/3-2_查询请求.md)
* [x] [3-3 用户详情请求](./doc/3-3_用户详情请求.md)
* [x] [3-4 用户创建请求](./doc/3-4_用户创建请求.md)
* [x] [3-5 修改和删除请求](./doc/3-5_修改和删除请求.md)
* [x] [3-6 服务异常处理](./doc/3-6_服务异常处理.md)
* [x] [3-7 使用切片拦截REST服务](./doc/3-7_使用切片拦截REST服务.md)
* [x] [3-8 使用Filter和Interceptor拦截REST服务](./doc/3-8_使用Filter和Interceptor拦截REST服务.md)
* [x] [3-9 使用REST方式处理文件服务](./doc/3-9_使用REST方式处理文件服务.md)
* [x] [3-10 使用多线程提高REST服务性能](./doc/3-10_使用多线程提高REST服务性能.md)
* [x] [3-11 使用Swagger自动生成文档](./doc/3-11_使用Swagger自动生成文档.md)
* [ ] [3-12 使用WireMock伪造REST服务](./doc/3-12_使用WireMock伪造REST服务.md)

## 第4章 使用Spring Security开发基于表单的登录

* [ ] [4-1 简介](./doc/4-1_简介.md)
* [ ] [4-2 SpringSecurity基本原理](./doc/4-2_SpringSecurity基本原理.md)
* [ ] [4-3 自定义用户认证逻辑](./doc/4-3_自定义用户认证逻辑.md)
* [ ] [4-4 个性化用户认证流程（一）](./doc/4-4_个性化用户认证流程.md)
* [ ] [4-5 个性化用户认证流程（二）](./doc/4-5_个性化用户认证流程.md)
* [ ] [4-6 认证流程源码级详解](./doc/4-6_认证流程源码级详解.md)
* [ ] [4-7 图片验证码](./doc/4-7_图片验证码.md)
* [ ] [4-8 图片验证码重构](./doc/4-8_图片验证码重构.md)
* [ ] [4-9 添加记住我功能](./doc/4-9_添加记住我功能.md)
* [ ] [4-10 短信验证码接口开发](./doc/4-10_短信验证码接口开发.md)
* [ ] [4-11 短信登录开发](./doc/4-11_短信登录开发.md)
* [ ] [4-12 短信登录配置及重构](./doc/4-12_短信登录配置及重构.md)
* [ ] [4-13 小结](./doc/4-13_小结.md)

## 第5章 使用Spring Social开发第三方登录

* [ ] [5-1 OAuth协议简介](./doc/5-1_OAuth协议简介.md)
* [ ] [5-2 SpringSocial简介](./doc/5-2_SpringSocial简介.md)
* [ ] [5-3 开发QQ登录（上）](./doc/5-3_开发QQ登录.md)
* [ ] [5-4 开发QQ登录（中）](./doc/5-4_开发QQ登录.md)
* [ ] [5-5 开发QQ登录（下）](./doc/5-5_开发QQ登录.md)
* [ ] [5-6 处理注册逻辑](./doc/5-6_处理注册逻辑.md)
* [ ] [5-7 开发微信登录](./doc/5-7_开发微信登录.md)
* [ ] [5-8 绑定和解绑处理](./doc/5-8_绑定和解绑处理.md)
* [ ] [5-9 单机Session管理](./doc/5-9_单机Session管理.md)
* [ ] [5-10 集群Session管理](./doc/5-10_集群Session管理.md)
* [ ] [5-11 退出登录](./doc/5-11_退出登录.md)

## 第6章 Spring Security OAuth开发APP认证框架

* [ ] [6-1 SpringSecurityOAuth简介](./doc/6-1_SpringSecurityOAuth简介.md)
* [ ] [6-2 实现标准的OAuth服务提供商](./doc/6-2_实现标准的OAuth服务提供商.md)
* [ ] [6-3 SpringSecurityOAuth核心源码解析](./doc/6-3_SpringSecurityOAuth核心源码解析.md)
* [ ] [6-4 重构用户名密码登录](./doc/6-4_重构用户名密码登录.md)
* [ ] [6-5 重构短信登录](./doc/6-5_重构短信登录.md)
* [ ] [6-6 重构社交登录](./doc/6-6_重构社交登录.md)
* [ ] [6-7 重构注册逻辑](./doc/6-7_重构注册逻辑.md)
* [ ] [6-8 令牌配置](./doc/6-8_令牌配置.md)
* [ ] [6-9 使用JWT替换默认令牌](./doc/6-9_使用JWT替换默认令牌.md)
* [ ] [6-10 基于JWT实现SSO单点登录1](./doc/6-10_基于JWT实现SSO单点登录1.md)
* [ ] [6-11 基于JWT实现SSO单点登录2](./doc/6-11_基于JWT实现SSO单点登录2.md)

## 第7章 使用Spring Security控制授权

* [ ] [7-1 SpringSecurity授权简介](./doc/7-1_SpringSecurity授权简介.md)
* [ ] [7-2 SpringSecurity源码解析](./doc/7-2_SpringSecurity源码解析.md)
* [ ] [7-3 权限表达式](./doc/7-3_权限表达式.md)
* [ ] [7-4 基于数据库Rbac数据模型控制权限](./doc/7-4_基于数据库Rbac数据模型控制权限.md)

## 第8章 课程总结

* [ ] [8-1 课程总结](./doc/8-1_课程总结.md)

