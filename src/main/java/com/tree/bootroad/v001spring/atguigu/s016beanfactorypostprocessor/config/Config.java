package com.tree.bootroad.v001spring.atguigu.s016beanfactorypostprocessor.config;

import com.tree.bootroad.v001spring.atguigu.s016beanfactorypostprocessor.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 扩展原理:
 * BeanPostProcessor: bean后置处理器, bean对象初始化前后工作
 * BeanFactoryPostProcessor: BeanFactory后置处理器
 *      时机: 在BeanFactory标准初始化后调用, 所有bean定义保存到BeanFactory, 但是bean实例未创建
 */
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s016beanfactorypostprocessor")
public class Config {

    @Bean
    public Blue blue(){
        return new Blue();
    }

}

