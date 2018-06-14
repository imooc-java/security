# 5-1 OAuth协议简介

## 使用 Spring Social 开发第三方登陆

### OAuth 协议简介

* OAuth 协议要解决的问题
* OAuth 协议中的各种角色
* OAuth 协议运行流程

#### OAuth 用户名密码模式

![](./img/5-1_OAuth用户名密码模式.png)

* 问题
  
  * 应用可以访问用户在微信上的所有数据
  * 用户只有修改密码，才能收回授权
  * 密码泄漏的可能性大大提高

#### OAuth 令牌模式

![](./img/5-1_OAuth_Token模式.png)

#### OAuth 基本流程

![](./img/5-1_OAuth基本流程.png)

#### OAuth 协议中的授权模式

* 授权码模式（authorization code）
  
  ![](./img/5-1_OAuth授权码模式流程.png)
  
* 密码模式（resource owner password credentials）
* 客户端模式（client credentials）
* 简化模式（implicit）
  
  > 第三方应用没有服务器，令牌存储在浏览器
  


