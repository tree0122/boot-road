package com.tree.bootroad.x002aop;

import com.tree.bootroad.x002aop.annotation.LogCost;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.stream.Collectors;

//@Aspect
@Slf4j
//@Component
public class LogAspectWithAnnotation {

    @Around("@annotation(logCost)")
    public Object around(ProceedingJoinPoint point, LogCost logCost){
        long start = System.currentTimeMillis();
        log.info("logCost: {}", logCost.value());

        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        String args = Arrays.stream(point.getArgs())
                .map(a -> String.valueOf(a))
                .map(a -> a.length() > 100 ? a.substring(0, 100) : a)
                .collect(Collectors.joining(",", "(", ")"));

        log.info("method: {}, args: {}, time cost: {}mm",
                point.getSignature().toShortString(),
                args,
                System.currentTimeMillis() - start);

        return proceed;
    }
}
