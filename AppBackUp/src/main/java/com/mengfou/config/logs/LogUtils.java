package com.mengfou.config.logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
class LogUtils {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 指定切面
    @Pointcut("execution(public * com.mengfou.controller.*.*(..))")
    public void withPointCut() {}

    // 方法之前执行
    @Before("withPointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        logger.info("进入了"+joinPoint.getSignature().getName() +"方法，参数有：" + Arrays.asList(joinPoint.getArgs()));
    }

    // 方法返回后
    @AfterReturning(value = "withPointCut()", returning = "obj")
    public void afterMethod(JoinPoint joinPoint, Object obj) {
        logger.info(joinPoint.getSignature().getName() +"方法执行完毕!");
    }
}