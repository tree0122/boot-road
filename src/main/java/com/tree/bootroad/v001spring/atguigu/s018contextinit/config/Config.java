package com.tree.bootroad.v001spring.atguigu.s018contextinit.config;

import com.tree.bootroad.v001spring.atguigu.s018contextinit.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s018contextinit")
public class Config {

    @Bean
    public Blue blue(){
        return new Blue();
    }

}

