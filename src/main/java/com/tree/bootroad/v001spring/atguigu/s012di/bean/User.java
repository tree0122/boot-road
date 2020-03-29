package com.tree.bootroad.v001spring.atguigu.s012di.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class User implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("============ User.setApplicationContext");
        this.applicationContext = applicationContext;
    }

    @Override
    public String toString() {
        return "User{" +
                "applicationContext=" + applicationContext +
                '}';
    }
}
