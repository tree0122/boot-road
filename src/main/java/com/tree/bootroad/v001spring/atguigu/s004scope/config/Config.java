package com.tree.bootroad.v001spring.atguigu.s004scope.config;

import com.tree.bootroad.v001spring.atguigu.s004scope.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;


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

    /**
     * @Lazy: 懒加载, 容器启动时不创建对象, 首次使用时创建
     * @return
     */
    @Lazy
    @Bean
    public Person person2(){
        System.out.println("==========person2 construct");
        return new Person(18, "lisi");
    }
}
