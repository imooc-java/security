package com.imooc.web.aspect;


import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class TimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimeAspect.class);

    @Around("execution(* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("TimeAspect start");

        logger.info("args: {}", ArrayUtils.toString(pjp.getArgs()));

        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        logger.info("TimeAspect 耗时：{} 毫秒", System.currentTimeMillis() - start);

        logger.info("TimeAspect end");

        return result;
    }

}
