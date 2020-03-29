<link rel="stylesheet" type="text/css" href="./auto-number-title.css" />

# Spring注解驱动开发

## 容器
### 容器(ApplicationContext)

### 组件添加
1. @ComponentScan + @Component: 自己的类
    1. @Component
    1. @Repository 
    1. @Service 
    1. @Controller
1. @Configuration + @Bean: 第三方包里的组件
1. @Import: 快速给容器导入一个组件
    1. @Import(要导入的组件): id是组件的全类名
    1. @ImportSelector: 返回需要的组件全类名数组
    1. @ImportBeanDefinitionRegistrar: 手动注册bean到容器
1. FactoryBean(工厂Bean)
    1. 默认获取的是FactoryBean.getObject()创建的对象
    1. 要获取FactoryBean, 需在id前加&(eg: &factoryBean)

### Bean生命周期
生命周期: bean创建 -> 初始化 -> 使用 -> 销毁的过程 (容器管理bean的声明周期)
1. bean的创建(bean的构造方法, 反射实现)
    1. 单例: 容器启动时创建
    1. 多例: 获取时创建
1. 属性赋值
1. 初始化: bean构造方法后, 并对属性赋值, 然后调用初始化方法
    1. @PostConstruct + @PreDestroy: bean的方法加上这两注解, InitDestroyAnnotationBeanPostProcessor实现
    1. InitializingBean + DisposableBean: bean实现这两接口
    1. @Bean(initMethod = "init", destroyMethod = "destroy")
    1. BeanPostProcessor, bean的后置处理器
        - postProcessBeforeInitialization: 初始化之前
        - postProcessAfterInitialization: 初始化之后
1. 销毁: 
    1. 单例: 容器关闭的时候
    1. 多例: 容器不管理多例的销毁

### 组件赋值
- @Value
    1. 基本数值
    1. SpEL: #{}
    1. ${}: 环境变量中的值

note: @PropertySource读取外部配置文件(不读取yml)    

### 组件注入
自动装配: 利用DI, 完成对容器中各组件的依赖关系赋值
1. @Autowired: 自动注入
    1. 默认优先按类型注入
    1. 如果有多个同类型组件, 再按id注入
    1. @Qualifier指定装配的组件id
    1. 自动装配默认默认属性, 否则报错. 
    @Autowired(required=false)可解决
    1. @Primary: 装配时默认首先bean
1. @Resouce: 和@Autowired类似
    1. 默认按属性名注入
    1. 不支持@Primary和@Autowired(required=false)
1. @Inject: 和@Autowired类似
1. AutowiredAnnotationBeanPostProcessor 实现这些注解注入
1. @Autowired使用范围: 构造方法, 属性, 方法, 参数. 从容器中获取
    1. 方法: 创建当前对象时, 调用该方法完成赋值
    1. 构造器: 仅有一个构造器, 则@Autowired可省
    1. 参数
1. @Bean标记的方法, 方法参数为自动注入
1. 需要容器底层的Aware组件(ApplicationContext), 实现对应的Aware接口
    - ApplicationContextAwareProcessor, 实现ApplicationContext相关
    - Bean初始化中invokeAwareMethods(), 实现BeanFactoryAware相关

### Profile
 @Profile: 写在配置类上, 仅指定的环境时, 整个配置类里的所有bean才生效
 1. Spring根据当前环境, 动态的激活和切换一系列组件
 1. 指定组件在哪个环境下能注册到容器; 不指定, 任何环境下都能注册到容器
    1. 加了环境标示的bean, 只有这个环境下能被注册到容器. 默认为default
    1. vm参数(-Dspring.profiles.active=dev), 可命令行指定环境标识
    1. 代码的方式, context创建时指定其环境标识
    

### AOP
### 声明式事务
***

## 扩展原理
### BeanFactoryPostProcessor
### BeanDefinitionRegistryPostProcessor
### ApplicationListener
### Spring容器创建过程
***

## web
### servlet3.0
### 异步请求

