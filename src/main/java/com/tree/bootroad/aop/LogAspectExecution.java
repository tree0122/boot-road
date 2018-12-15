package com.tree.bootroad.aop;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Slf4j
@Component
public class LogAspectExecution {

    /** ________________________________________________________________________________
     *  |               execution(* com.sample.service.impl..*.*(..))                  |
     * -+---------------------------+--------------------------------------------------+
     *  |           符号	            |                       含义                       |
     *  +---------------------------+--------------------------------------------------+
     *  |       execution()         |                   表达式的主体；                   |
     *  +---------------------------+--------------------------------------------------+
     *  |       第一个"*"符号        |               表示返回值的类型任意                  |
     *  +---------------------------+--------------------------------------------------+
     *  |   com.sample.service.impl |      AOP所切的服务的包名，即，我们的业务部分          |
     *  +---------------------------+--------------------------------------------------+
     *  |       包名后面的 ".."      |	            表示当前包及子包                     |
     *  +---------------------------+--------------------------------------------------+
     *  |          第二个"*"	        |    表示类名, *即所有类, 此处可以自定义, 下文有举例    |
     *  +---------------------------+--------------------------------------------------+
     *  |          .*(..)           |   表示任何方法名，括号表示参数，两个点表示任何参数类型  |
     *  +---------------------------+--------------------------------------------------+
     *
     *
     */
    @Pointcut("execution(* com.tree.bootroad.controller..*.*(..))")
    public void logMethod(){}

    @Around("logMethod()")
    public Object around(ProceedingJoinPoint point){
        long start = System.currentTimeMillis();

        Object proceed = null;
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        System.out.println(request.getRequestURI());
        log.info("method: {}, args: {}, time cost: {}mm",
                point.getSignature().toShortString(),
                Lists.newArrayList(point.getArgs()),
                System.currentTimeMillis() - start);

        return proceed;
    }
}
