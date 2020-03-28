package com.tree.bootroad.v001spring.atguigu.s010beanlife.config;

import com.tree.bootroad.v001spring.atguigu.s010beanlife.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s010beanlife")
public class Config {

    @Bean(initMethod = "init", destroyMethod = "destroyMethod")
    public Car car(){
        return new Car();
    }

}

