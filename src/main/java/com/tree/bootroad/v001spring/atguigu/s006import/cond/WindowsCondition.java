package com.tree.bootroad.v001spring.atguigu.s006import.cond;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 是否win os
 */
public class WindowsCondition implements Condition {
    /**
     *
     * @param context: 判断条件能使用的上下文(环境)
     * @param metadata: 注解信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        ClassLoader classLoader = context.getClassLoader();
        // bean的定义
        BeanDefinitionRegistry registry = context.getRegistry();
        String osName = context.getEnvironment().getProperty("os.name");
        return osName.contains("Windows");
    }

}
