package com.tree.bootroad.v001spring.atguigu.s013profile;

import com.tree.bootroad.v001spring.atguigu.s013profile.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {

       /* // 代码激活某个环境
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(Config.class);
        context.refresh();*/


        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("context完成");
        printBeans(context);

        /*Person bean = context.getBean(Person.class);
        System.out.println(bean);*/

        ((AnnotationConfigApplicationContext) context).close();
    }

    private static void printBeans(ApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
