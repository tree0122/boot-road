package com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {

    private TargetTeacher targetTeacher;

    public CglibProxyFactory(TargetTeacher targetTeacher) {
        this.targetTeacher = targetTeacher;
    }

    public TargetTeacher getProxy(){
        // 1 创建工具类
        Enhancer enhancer = new Enhancer();
        // 2 设置父类
        enhancer.setSuperclass(targetTeacher.getClass());
        // 3 设置回调函数
        enhancer.setCallback(this);
        // 4 创建子类对象(代理对象)
        return (TargetTeacher) enhancer.create();
    }

    // 调用目标对象的方法
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib 代理模式----开始");
        Object ret = method.invoke(targetTeacher, args);
        System.out.println("Cglib 代理模式----提交");
        return ret;
    }
}
