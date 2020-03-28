package com.tree.bootroad.v001spring.atguigu.s004scope.config;

import com.tree.bootroad.v001spring.atguigu.s004scope.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s004scope")
public class Config {

    /**
     * @Scope的值:
     *      ConfigurableBeanFactory.SCOPE_SINGLETON 单实例, 容器启动时创建对象
     *      ConfigurableBeanFactory.SCOPE_PROTOTYPE 多实例, 每次获取时创建对象
     * @return
     */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public Person person(){
        System.out.println("==========person construct");
        return new Person(18, "zhangsan");
    }
}
