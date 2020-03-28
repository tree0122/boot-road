package com.tree.bootroad.v001spring.atguigu.s008importbeandefinitionregistrar.cond;

import com.tree.bootroad.v001spring.atguigu.s008importbeandefinitionregistrar.bean.Blue;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 手动注册bean
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @param registry BeanDefinition的注册类
     * 所有需要添加到容器中的bean, 手动调用 BeanDefinitionRegistry. registerBeanDefinition()
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean hasRed = registry.containsBeanDefinition("com.tree.bootroad.v001spring.atguigu.s007importselector.bean.Red");
        if (hasRed){
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
//            AbstractBeanDefinition bd = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();

            registry.registerBeanDefinition("blue", beanDefinition);
        }
    }
}
