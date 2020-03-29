package com.tree.bootroad.v001spring.atguigu.s014aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class MarkAspect {

    @Around("@annotation(Mark)")
    public Object around(ProceedingJoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("around before method, method: {}, param: {}", method, Arrays.asList(args));

        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("around throw method, method: {}, param: {}, Exception: {}", method, Arrays.asList(args), throwable);
        }

        log.info("around after method, method: {}, param: {}, ret: {}", method, Arrays.asList(args), proceed);

        return proceed;
    }
}
