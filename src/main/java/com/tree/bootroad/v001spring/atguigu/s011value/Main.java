package com.tree.bootroad.v001spring.atguigu.s011value;

import com.tree.bootroad.v001spring.atguigu.s011value.bean.Person;
import com.tree.bootroad.v001spring.atguigu.s011value.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("context完成");
        printBeans(context);
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
        System.out.println(context.getEnvironment().getProperty("person.nickName"));
        ((AnnotationConfigApplicationContext) context).close();
    }

    private static void printBeans(ApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
