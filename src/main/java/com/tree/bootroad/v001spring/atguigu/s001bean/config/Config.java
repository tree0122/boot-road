package com.tree.bootroad.v001spring.atguigu.s001bean.config;

import com.tree.bootroad.v001spring.atguigu.s001bean.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Person person(){
        return new Person(18, "best");
    }

}
