package com.tree.bootroad.v001spring.atguigu.s015tx;

import com.tree.bootroad.v001spring.atguigu.s015tx.config.Config;
import com.tree.bootroad.v001spring.atguigu.s015tx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("context完成");
        printBeans(context);

        UserService userService = context.getBean(UserService.class);
        userService.insert();

        ((AnnotationConfigApplicationContext) context).close();
    }

    private static void printBeans(ApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
