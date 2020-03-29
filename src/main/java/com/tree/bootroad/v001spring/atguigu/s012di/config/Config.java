package com.tree.bootroad.v001spring.atguigu.s012di.config;

import com.tree.bootroad.v001spring.atguigu.s012di.Dao.BookDao;
import com.tree.bootroad.v001spring.atguigu.s012di.bean.Car;
import com.tree.bootroad.v001spring.atguigu.s012di.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *  @Autowired: 自动注入
 *     1. 默认优先按类型注入
 *     2. 如果有多个同类型组件, 再按id注入
 *     3. @Qualifier指定装配的组件id
 *     4. 自动装配默认默认属性, 否则报错. @Autowired(required=false)可解决
 *     5. @Primary: 装配时默认首先bean
 *  @Resource: 和@Autowired类似
 *   1. 默认按属性名注入
 *   2. 不支持@Primary和@Autowired(required=false)
 *  @Inject: 和@Autowired类似
 *
 *  AutowiredAnnotationBeanPostProcessor 实现这些注解注入
 *
 *  @Autowired使用范围: 构造方法, 属性, 方法, 参数. 从容器中获取
 *     1. 方法: 创建当前对象时, 调用该方法完成赋值
 *     2. 构造器: 有参构造器
 *     3. 参数
 *
 *  需要容器底层的Aware组件(ApplicationContext, BeanFactory等), 实现对应的Aware接口
 *     - ApplicationContextAwareProcessor, 实现ApplicationContext相关
 *     - Bean初始化过程中invokeAwareMethod(), 实现BeanFactoryAware相关
 *
 */
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s012di")
public class Config {

//    @Primary
    @Bean
    public BookDao bookDao2(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    /**
     *
     *  @Bean标记的方法, 方法参数为自动注入(默认不加@Autowired)
     * @param car
     * @return
     */
    @Bean
    public Employee employee(Car car){
        Employee employee = new Employee();
        employee.setCar(car);
        return employee;
    }
}

