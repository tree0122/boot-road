package com.tree.bootroad.x002aop;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
//@Component
public class LogAspect {

    @Pointcut("@annotation(com.tree.bootroad.x002aop.annotation.LogCost)")
    public void log(){}

    @Around("log()")
    public Object around(ProceedingJoinPoint point){
        long start = System.currentTimeMillis();

        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        log.info("method: {}, args: {}, time cost: {}mm",
                point.getSignature().toShortString(),
                Lists.newArrayList(point.getArgs()),
                System.currentTimeMillis() - start);

        return proceed;
    }
}
