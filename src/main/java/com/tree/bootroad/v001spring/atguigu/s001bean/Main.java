package com.tree.bootroad.v001spring.atguigu.s001bean;

import com.tree.bootroad.v001spring.atguigu.s001bean.bean.Person;
import com.tree.bootroad.v001spring.atguigu.s001bean.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Object person = applicationContext.getBean("person");
        log.info("{}", person);
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            log.info("bean name: {}", name);
        }
    }
}
