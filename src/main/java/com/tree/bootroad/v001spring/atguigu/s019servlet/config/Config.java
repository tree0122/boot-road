package com.tree.bootroad.v001spring.atguigu.s019servlet.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s019servlet")
@ServletComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s019servlet")
public class Config {

    @Bean
    public TomcatServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory(8080);
    }
}

