# 3-1 RESTful简介

## 学习内容

* 使用 Spring MVC 编写 RESTful API
* 使用 Spring MVC 处理其它 web 应用常见的需求和场景
* RESTful API 开发常用辅助框架

## 第一印象

| 操作类型 |           传统请求           | 请求类型 |   RESTful请求  | 请求类型 |
|:--------:|:----------------------------:|:--------:|:--------------:|:--------:|
| 查询     | /user/query?name=tom         | GET      | /user?name=tom | GET      |
| 详情     | /user/getInfo?id=1           | GET      | /user/1        | GET      |
| 创建     | /user/create?name=tom        | POST     | /user          | POST     |
| 修改     | /user/update?id=1&name=jerry | POST     | /user/1        | PUT      |
| 删除     | /user/delete?id=1            | GET      | /user/1        | DELETE   |

1. 用 URL 描述资源
2. 使用 HTTP 方法描述行为。使用 HTTP 状态码来表示不同的结果
3. 使用 json 交互数据
4. RESTful 只是一种风格，并不是强制的标准

## REST 成熟度模型

* Level 0 : The Swamp of POX
  * 使用 Http 作为传输方式
* Level 1 : Resources
  * 引入资源概念
  * 每个资源有对应的 URL
* Level 2 : HTTP Verbs
  * 使用 HTTP 方法进行不同的操作
  * 使用 HTTP 状态码来表示不同的结果
* Level 3 : Hypermedia Controls
  * 使用超媒体
  * 在资源的表达中包含了链接信息

