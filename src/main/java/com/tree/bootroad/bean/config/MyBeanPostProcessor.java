package com.tree.bootroad.bean.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor{
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("BeanPostProcessor.postProcessBeforeInitialization, bean: {}", beanName);
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("BeanPostProcessor.postProcessAfterInitialization, bean: {}", beanName);
        return bean;
    }
}
