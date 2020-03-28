<link rel="stylesheet" type="text/css" href="./auto-number-title.css" />

# Spring注解驱动开发

## 容器
### 容器(ApplicationContext)

### 组件添加
1. @ComponentScan + @Component: 自己的类
    1. @Component
    1. @Reposity 
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
- @Autowired
- @Resouce
- @Inject

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

