package com.tree.bootroad.v001spring.atguigu.s003typefilter;

import com.tree.bootroad.v001spring.atguigu.s003typefilter.config.Config;
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
    }

}
