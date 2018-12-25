package com.tree.bootroad.bean.config;

import com.tree.bootroad.bean.LifeCircle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "init")
    public LifeCircle lifeCircle(){
        return new LifeCircle();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

}
