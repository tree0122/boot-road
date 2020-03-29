package com.tree.bootroad.v001spring.atguigu.s014aop;

import com.tree.bootroad.v001spring.atguigu.s014aop.annotation.Say;
import com.tree.bootroad.v001spring.atguigu.s014aop.config.Config;
import com.tree.bootroad.v001spring.atguigu.s014aop.service.MathCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("context完成");
        printBeans(context);

        /*Person bean = context.getBean(Person.class);
        System.out.println(bean);*/

        MathCalculator bean = context.getBean(MathCalculator.class);
        bean.div(3, 2);
//        bean.div(1, 0);

        Say say = context.getBean(Say.class);
        say.echo("hello !");

        ((AnnotationConfigApplicationContext) context).close();
    }

    private static void printBeans(ApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
