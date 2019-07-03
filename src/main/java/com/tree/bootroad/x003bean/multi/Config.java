package com.tree.bootroad.x003bean.multi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ResourceService resourceService1(){
        return new ResourceService();
    }

    @Bean
    public ResourceService resourceService2(){
        return new ResourceService();
    }

}
