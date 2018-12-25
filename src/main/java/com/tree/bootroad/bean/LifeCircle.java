package com.tree.bootroad.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class LifeCircle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        InitializingBean, DisposableBean{
    // 1
    public LifeCircle() {
        log.info("constructor");
    }

    // 2
    @Override
    public void setBeanName(String s) {
        log.info("BeanNameAware.setBeanName");
    }

    // 3
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("BeanFactoryAware.setBeanFactory");
    }

    // 4
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("ApplicationContextAware.setApplicationContext");
    }

    // 6
    @PostConstruct
    public void postConstruct(){
        log.info("postConstruct");
    }

    // 7
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean.afterPropertiesSet");
    }

    // 8
    public void init(){
        log.info("custom init");
    }

    // 10
    @PreDestroy
    public void PreDestroy(){
        log.info("PreDestroy");
    }

    // 11
    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean.destroy");
    }

}
