package com.tree.bootroad.v001spring.atguigu.s009factorybean.config;

import com.tree.bootroad.v001spring.atguigu.s009factorybean.bean.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s009factorybean")
public class Config {

    /**
     * 默认获取的是FactoryBean.getObject()创建的对象(通过id获取)
     * 要获取FactoryBean, 需在id前加&(eg: &factoryBean)
     * @return
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}

