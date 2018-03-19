# 4-2 SpringSecurity基本原理

## Spring Secutiry 过滤器链

* 请求
* UsernamePasswordAuthenticationFilter
* BasicAuthenticationFilter
* ...
* ExceptionTranslationFilter
* FilterSecurityInterceptor
* REST API
* 响应

## 问题整理

* 表单验证设置无效

  问题原因：demo 和 browser 包名不一致，导致无法加载类 BrowserSecurityConfig 
  @SpringBootApplication 注解，包含 @ComponentScan
  @ComponentScan：会自动扫描指定包下的全部标有@Component的类，并注册成bean，当然包括@Component下的子注解@Service,@Repository,@Controller

