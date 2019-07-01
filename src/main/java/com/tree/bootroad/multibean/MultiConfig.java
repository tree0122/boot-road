package com.tree.bootroad.multibean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiConfig {

    @Bean
    public MultiService multiService(){
        return new MultiService();
    }

    @Bean
    public Service0 service2(){
        return new Service0();
    }

    @Bean
    public Service0 service1(){
        return new Service0();
    }
}
