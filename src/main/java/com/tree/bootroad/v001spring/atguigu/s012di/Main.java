package com.tree.bootroad.v001spring.atguigu.s012di;

import com.tree.bootroad.v001spring.atguigu.s012di.config.Config;
import com.tree.bootroad.v001spring.atguigu.s012di.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("context完成");
        printBeans(context);
        BookService bean = context.getBean(BookService.class);
        System.out.println(bean);
        ((AnnotationConfigApplicationContext) context).close();
    }

    private static void printBeans(ApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
