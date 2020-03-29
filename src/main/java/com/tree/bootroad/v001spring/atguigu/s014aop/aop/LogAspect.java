package com.tree.bootroad.v001spring.atguigu.s014aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Component
@Aspect
public class LogAspect {

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
     */
    @Pointcut("execution(public * com.tree.bootroad.v001spring.atguigu.s014aop.service.MathCalculator.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void start(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("before method, method: {}, param: {}", method, Arrays.asList(args));
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("after method, method: {}, param: {}", method, Arrays.asList(args));
    }

    @AfterReturning(value = "pointCut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret){
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("afterReturning method, method: {}, param: {}, return: {}", method, Arrays.asList(args), ret);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("afterThrowing method, method: {}, param: {}, Exception: {}", method, Arrays.asList(args), e);
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("around before method, method: {}, param: {}", method, Arrays.asList(args));
        Object ret = null;
        try {
            ret = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("around throw method, method: {}, param: {}, Exception: {}", method, Arrays.asList(args), throwable);
        }
        log.info("around after method, method: {}, param: {}, ret: {}", method, Arrays.asList(args), ret);
        return ret;
    }
}
