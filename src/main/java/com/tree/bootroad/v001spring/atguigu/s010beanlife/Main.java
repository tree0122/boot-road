package com.tree.bootroad.v001spring.atguigu.s010beanlife;

import com.tree.bootroad.v001spring.atguigu.s010beanlife.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 生命周期: bean创建 -> 初始化 -> 使用 -> 销毁的过程 (容器管理bean的声明周期)
 * 1. bean的创建(bean的构造方法, 反射实现)
 *     1). 单例: 容器启动时创建
 *     2). 多例: 获取时创建
 * 2. 属性赋值
 * 3. 初始化: bean构造方法后, 并对属性赋值, 然后调用初始化方法
 *     1). @PostConstruct + @PreDestroy: bean的方法加上这两注解
 *     2). InitializingBean + DisposableBean: bean实现这两接口
 *     3). @Bean(initMethod = "init", destroyMethod = "destroy")
 *     4). BeanPostProcessor, bean的后置处理器
 *         1> postProcessBeforeInitialization: 初始化之前
 *         2> postProcessAfterInitialization: 初始化之后
 * 4. 销毁:
 *     1). 单例: 容器关闭的时候
 *     2). 多例: 容器不管理多例的销毁
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("context完成");
        printBeans(context);
        ((AnnotationConfigApplicationContext) context).close();
    }

    private static void printBeans(ApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
       /* Map<String, Object> beanMap = context.getBeansOfType(Object.class);
        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            System.out.println(entry);
        }*/
    }

}
