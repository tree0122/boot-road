package com.tree.bootroad.v001spring.atguigu.s009factorybean;

import com.tree.bootroad.v001spring.atguigu.s009factorybean.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        printBeans(context);
        Object bean = context.getBean("colorFactoryBean");
        System.out.println(bean);
        Object bean1 = context.getBean("&colorFactoryBean");
        System.out.println(bean1);
    }

    private static void printBeans(ApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
