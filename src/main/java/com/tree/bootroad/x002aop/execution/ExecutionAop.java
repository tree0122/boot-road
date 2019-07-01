package com.tree.bootroad.x002aop.execution;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class ExecutionAop {

    @Pointcut("execution(* com.tree.bootroad.x002aop.service..*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============Before, method: {}", method.getName());
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============After, method: {}", method.getName());
    }

    @AfterReturning(value = "pointcut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============AfterReturning, method: {}, ret: {}", method.getName(), ret);
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============AfterThrowing, method: {}", method.getName());
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException("");
        }finally {
            log.info("============Around, method: {}", method.getName());
        }
    }

}
