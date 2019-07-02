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
public class AnnotationAopBetter {

    @Around("@annotation(LogCost)")
    public Object around(ProceedingJoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============AnnotationAopBetter#Around, first enter,method: {}", method.getName());
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException("");
        }finally {
            log.info("============AnnotationAopBetter#Around, second enter,method: {}", method.getName());
        }
    }
}
