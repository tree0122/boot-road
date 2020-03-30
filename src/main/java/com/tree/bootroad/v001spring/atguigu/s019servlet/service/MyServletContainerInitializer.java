package com.tree.bootroad.v001spring.atguigu.s019servlet.service;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @HandlesTypes:
 * servlet容器启动时, 将其指定的类型子类(实现类, 子接口等) 传递过来
 */
@HandlesTypes(HelloService.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * 应用启动时, 运行
     * @param c : @HandlesTypes 感兴趣的所有子类
     * @param ctx: web应用的上下文
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("感兴趣的类型:");
        for (Class<?> aClass : c) {
            System.out.println(aClass);
        }
    }
}
