package com.tree.bootroad.x001beanlife;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeConfig {

    @Bean
    public LifeInstantiationAwareBeanPostProcessor lifeInstantiationAwareBeanPostProcessor(){
        return new LifeInstantiationAwareBeanPostProcessor();
    }

    @Bean
    public LifeBeanPostProcessor lifeBeanPostProcessor(){
        return new LifeBeanPostProcessor();
    }

    @Slf4j
    public static class LifeInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor{
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (beanName.equals("bananaLife")){
                log.error("beanName: {}, postProcessBeforeInstantiation", beanName);
            }
            return null;
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (beanName.equals("bananaLife")){
                log.error("order: {}, beanName: {}, postProcessAfterInstantiation", ++((BananaLife) bean).order, beanName);
            }
            return true;
        }

        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            if (beanName.equals("bananaLife")){
                log.error("order: {}, beanName: {}, postProcessProperties", ++((BananaLife) bean).order, beanName);
            }
            return null;
        }
    }

    @Slf4j
    public static class LifeBeanPostProcessor implements BeanPostProcessor{
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            if (beanName.equals("bananaLife")){
                log.error("order: {}, beanName: {}, postProcessBeforeInitialization", ++((BananaLife) bean).order, beanName);
            }
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (beanName.equals("bananaLife")){
                log.error("order: {}, beanName: {}, postProcessAfterInitialization", ++((BananaLife) bean).order, beanName);
            }
            return bean;
        }
    }

}
