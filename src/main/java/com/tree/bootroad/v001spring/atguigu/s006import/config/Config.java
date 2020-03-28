package com.tree.bootroad.v001spring.atguigu.s006import.config;

import com.tree.bootroad.v001spring.atguigu.s006import.bean.Color;
import com.tree.bootroad.v001spring.atguigu.s006import.bean.Person;
import com.tree.bootroad.v001spring.atguigu.s006import.bean.Red;
import com.tree.bootroad.v001spring.atguigu.s006import.cond.LinuxCondition;
import com.tree.bootroad.v001spring.atguigu.s006import.cond.WindowsCondition;
import org.springframework.context.annotation.*;


/**
 * @Import: 快速导入组件, id是组件的全类名
 */
@Import({Color.class, Red.class})
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s006import")
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

