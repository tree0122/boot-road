package com.tree.bootroad.v001spring.atguigu.s011value.config;

import com.tree.bootroad.v001spring.atguigu.s011value.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * @PropertySource: 默认不加载yml文件, 如果需要, 则自定义PropertySourceFactory.class
 */
@PropertySource(value = "classpath:/config.yml", factory = ConfigSourceFactory.class)
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s011value")
public class Config {

    @Bean
    public Person person(){
        return new Person();
    }
}

