package com.tree.bootroad.v001spring.atguigu.s005conditional.config;

import com.tree.bootroad.v001spring.atguigu.s005conditional.bean.Person;
import com.tree.bootroad.v001spring.atguigu.s005conditional.cond.LinuxCondition;
import com.tree.bootroad.v001spring.atguigu.s005conditional.cond.WindowsCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s005conditional")
public class Config {

    /**
     * @Conditional:
     *      方法上, 作用域在此方法
     *      类上, 作用域在次类
     * @return
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person3(){
        System.out.println("==========person3 construct");
        return new Person(60, "bill");
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person4(){
        System.out.println("==========person4 construct");
        return new Person(50, "linus");
    }

}
