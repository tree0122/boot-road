package com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.interfaces;

import com.tree.bootroad.v004designpattern.atguigu.design.d12proxy.sample.proxy.ITeacher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {

    private ITeacher target;

    public JdkProxyFactory(ITeacher target) {
        this.target = target;
    }

    public ITeacher getProxy(){
        return (ITeacher) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK 开始");
                        Object ret = method.invoke(target, args);
                        System.out.println("JDK 完成");
                        return ret;
                    }
                }
        );
    }

}
