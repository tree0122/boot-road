package com.tree.bootroad.v001spring.atguigu.s001bean.config;

import com.tree.bootroad.v001spring.atguigu.s001bean.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 告诉spring这是一个配置类
 *
 * 配置类, 也就是配置文件(xml)
 */
@Configuration
public class Config {

    /**
     * @Bean给容器注册一个Bean: 类型为返回的类型, id默认是方法名
     * @return
     */
    @Bean
    public Person person(){
        return new Person(18, "best");
    }

}
