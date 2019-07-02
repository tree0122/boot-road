package com.tree.bootroad.x001beanlife;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
@Slf4j
public class BananaLife implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    @Value("{banana.color:green}")
    private String color;

    int order = 0;

    @Resource
    private LifeConfig.LifeBeanPostProcessor lifeBeanPostProcessor;

    public BananaLife(){
       log.error("order: {}, constructor.............", ++order);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        log.error("order: {}, setColor.............", ++order);
        this.color = color;
    }

    @Override
    public void setBeanName(String name) {
        log.error("order: {}, setBeanName.............", ++order);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.error("order: {}, setBeanFactory.............", ++order);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.error("order: {}, afterPropertiesSet.............", ++order);
    }

    @PostConstruct
    public void init(){
        log.error("order: {}, PostConstruct.............", ++order);
    }

    @Override
    public void destroy() throws Exception {
        log.error("order: {}, destroy.............", ++order);
    }

    @PreDestroy
    public void predestroy(){
        log.error("order: {}, PreDestroy.............", ++order);
    }
}
