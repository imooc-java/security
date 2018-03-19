package com.imooc.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TimeInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle");
        request.setAttribute("startTime", System.currentTimeMillis());

        logger.info(((HandlerMethod) handler).getBean().getClass().getName());
        logger.info(((HandlerMethod) handler).getMethod().getName());

        // 决定是否继续 postHandle 和 afterCompletion
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle");

        Long startTime = (Long) request.getAttribute("startTime");

        logger.info("TimeInterceptor 耗时: {} 毫秒", System.currentTimeMillis() - startTime);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion");

        Long startTime = (Long) request.getAttribute("startTime");

        logger.info("TimeInterceptor 耗时: {} 毫秒", System.currentTimeMillis() - startTime);

        logger.info("ex is {}", ex);
    }
}
