package com.tree.bootroad.v001spring.atguigu.s004scope;

import com.tree.bootroad.v001spring.atguigu.s004scope.bean.Person;
import com.tree.bootroad.v001spring.atguigu.s004scope.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames) {
            log.info("component: {}", name);
        }
        Person bean = context.getBean(Person.class);
        Person bean2 = context.getBean(Person.class);
        System.out.println(bean == bean2); // false
    }

}
