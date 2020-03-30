package com.tree.bootroad.v001spring.atguigu.s021async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigServletWebServerApplicationContext(Config.class);
//        System.out.println("context完成");
//        printBeans(context);


//        ((AnnotationConfigApplicationContext) context).close();
    }

    private static void printBeans(ApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
