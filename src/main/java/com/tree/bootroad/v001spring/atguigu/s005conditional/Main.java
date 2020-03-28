package com.tree.bootroad.v001spring.atguigu.s005conditional;

import com.tree.bootroad.v001spring.atguigu.s005conditional.bean.Person;
import com.tree.bootroad.v001spring.atguigu.s005conditional.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }

        Map<String, Person> personMap = context.getBeansOfType(Person.class);
        System.out.println(personMap);
    }

}
