package com.tree.bootroad.v001spring.atguigu.s010beanlife.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements InitializingBean, DisposableBean {

    public Car(){
        System.out.println("car...........constructor----------");
    }

    public void init(){
        System.out.println("car...........@Bean(init = )----------");
    }

    public void destroyMethod(){
        System.out.println("car...........@Bean(destroyMethod = )----------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car...........InitializingBean.afterPropertiesSet()----------");
    }

    @Override
    public void destroy(){
        System.out.println("car...........DisposableBean.destroy()----------");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("car...........@PostConstruct----------");
    }

    @PreDestroy
    public void PreDestroy(){
        System.out.println("car...........@PreDestroy----------");
    }

}
