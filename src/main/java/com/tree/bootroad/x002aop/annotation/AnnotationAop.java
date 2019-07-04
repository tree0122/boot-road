package com.tree.bootroad.x002aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class AnnotationAop {

    @Pointcut(value = "@annotation(logCost)", argNames = "logCost")
    public void pointcut(LogCost logCost){}


    @Around(value = "pointcut(logCost)", argNames = "joinPoint,logCost")
    public Object around(ProceedingJoinPoint joinPoint, LogCost logCost){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============AnnotationAop#Around, first enter,method: {}", method.getName());
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException("");
        }finally {
            log.info("============AnnotationAop#Around, second enter,method: {}", method.getName());
        }
    }
}