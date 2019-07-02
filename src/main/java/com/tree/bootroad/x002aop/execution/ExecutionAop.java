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
    @Pointcut("execution(* com.tree.bootroad.x002aop.service..*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============ExecutionAop#Before, method: {}", method.getName());
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============ExecutionAop#After, method: {}", method.getName());
    }

    @AfterReturning(value = "pointcut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, Object ret){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============ExecutionAop#AfterReturning, method: {}, ret: {}", method.getName(), ret);
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(JoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============ExecutionAop#AfterThrowing, method: {}", method.getName());
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("============ExecutionAop#Around, first enter, method: {}", method.getName());
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException("");
        }finally {
            log.info("============ExecutionAop#Around, second enter, method: {}", method.getName());
        }
    }

}
