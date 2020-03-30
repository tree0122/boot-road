# Spring注解驱动开发

## 容器
### 容器(ApplicationContext)

### [组件添加](./src/main/java/com/tree/bootroad/v001spring/atguigu/s009factorybean/README.md)
1. @ComponentScan + @Component: 自己的类
1. @Configuration + @Bean: 第三方包里的组件
1. @Import: 快速给容器导入一个组件
1. FactoryBean(工厂Bean)

### [Bean生命周期](./src/main/java/com/tree/bootroad/v001spring/atguigu/s010beanlife/README.md)
生命周期: bean创建 -> 初始化 -> 使用 -> 销毁的过程 (容器管理bean的声明周期)
1. bean的创建(bean的构造方法, 反射实现)
1. 属性赋值
1. 初始化: bean构造方法后, 并对属性赋值, 然后调用初始化方法
1. 销毁: 

### [组件赋值](./src/main/java/com/tree/bootroad/v001spring/atguigu/s011value/README.md)
1. @Value
    - 基本数值
    - SpEL: #{}
    - ${}: 环境变量中的值

1. note: @PropertySource读取外部配置文件(不读取yml)    

### [组件注入](./src/main/java/com/tree/bootroad/v001spring/atguigu/s012di/README.md)
自动装配: 利用DI, 完成对容器中各组件的依赖关系赋值
1. @Autowired: 自动注入
    - 默认优先按类型注入
    - 如果有多个同类型组件, 再按id注入
    - @Qualifier指定装配的组件id
    - 自动装配默认默认属性, 否则报错. @Autowired(required=false)可解决
    - @Primary: 装配时默认首先bean
1. @Resource: 和@Autowired类似
    - 默认按属性名注入
    - 不支持@Primary和@Autowired(required=false)
1. @Inject: 和@Autowired类似
1. AutowiredAnnotationBeanPostProcessor 实现这些注解注入
1. @Autowired使用范围: 构造方法, 属性, 方法, 参数. 从容器中获取
    - 方法: 创建当前对象时, 调用该方法完成赋值
    - 构造器: 仅有一个构造器, 则@Autowired可省
    - 参数
1. @Bean标记的方法, 方法参数为自动注入
1. 需要容器底层的Aware组件(ApplicationContext), 实现对应的Aware接口
    - ApplicationContextAwareProcessor, 实现ApplicationContext相关
    - Bean初始化中invokeAwareMethods(), 实现BeanFactoryAware相关

### [Profile](./src/main/java/com/tree/bootroad/v001spring/atguigu/s013profile/README.md)
 @Profile: 写在配置类上, 仅指定的环境时, 整个配置类里的所有bean才生效
 1. Spring根据当前环境, 动态的激活和切换一系列组件
 1. 指定组件在哪个环境下能注册到容器; 不指定, 任何环境下都能注册到容器
    - 加了环境标示的bean, 只有这个环境下能被注册到容器. 默认为default
    - vm参数(-Dspring.profiles.active=dev), 可命令行指定环境标识
    - 代码的方式, context创建时指定其环境标识
    

### [AOP](./src/main/java/com/tree/bootroad/v001spring/atguigu/s014aop/EXPLAIN.md)
使用步骤:
1. 导入aop模块, Spring AOP (Spring-aspects)
1. 定义一个业务逻辑类; 需求是在业务运行时, 打印日志
1. 定义一个日志切面类; 切面类里面的方法, 动态感知业务逻辑的运行
    - @Before: 前置通知, 目标方法前
    - @After: 后置通知, 目标方法结束后(无论正常 异常)
    - @AfterReturning: 目标方法正常返回后通知
    - @AfterThrowing: 目标方法异常通知
    - @Around: 环绕通知, 手动目标方法运行(ProceedingJoinPoint.proceed())
1. 定义切面类的方法何时运行(通知注解)
1. 将切面类和业务类, 都交给容器
1. 指定切面类(@Aspect)
1. 给配置类添加@EnableAspectJAutoProxy, 开启基于注解的AOP

主要三步:
1. 将业务组件和切面组件加入容器, 并告诉Spring哪个是切面
1. 在切面组件的每个通知方法上, 标注通知注解, 告诉Spring何时何地运行(切点表达式)
1. 开启基于注解的AOP模式      

### [声明式事务](./src/main/java/com/tree/bootroad/v001spring/atguigu/s015tx/README.md)

使用步骤:
1. 导入相关依赖(数据源, 数据库驱动, spring-jdbc)
1. 配置数据源, JdbcTemplate
1. 给方法上标注@Transactional, 表示此方法是一个事务方法
1. @EnableTransactionManagement: 开启基于注解的事务
1. 配置事务管理器 PlatformTransactionManager


## 扩展原理

### [BeanFactoryPostProcessor](./src/main/java/com/tree/bootroad/v001spring/atguigu/s016beanfactorypostprocessor/README.md)

1. BeanPostProcessor: bean后置处理器, bean对象初始化前后工作
1. BeanFactoryPostProcessor: BeanFactory后置处理器
1. 时机: 在BeanFactory标准初始化后调用, 所有bean定义保存到BeanFactory, 但是bean实例未创建

### BeanDefinitionRegistryPostProcessor

1. postProcessBeanDefinitionRegistry(): 有bean定义将被加载, bean未创建
1. 先于BeanFactoryPostProcessor执行: 利用这个, 再给容器额外添加一下组件定义

### [ApplicationListener](./src/main/java/com/tree/bootroad/v001spring/atguigu/s017applicationlistener/README.md)
监听容器中分布的事件, 事件驱动模型开发:

步骤:
1. 注册一个监听器(ApplicationListener)监听某事件(ApplicationEvent)
    - ApplicationListener的bean: 实现接口
    - @EventListener: 任何bean方法的添加注解
1. 只要容器中有相关事件发布, 就能监听到这事件
    - ContextRefreshedEvent: 容器刷新完成事件
    - ContextClosedEvent: 容器关闭事件
1. 发布事件 context.publishEvent() 

着重: ApplicationContext实例化过程中顺序如下
1. BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry(): 所有bean定义加载后, 可加额外bean定义
1. BeanFactoryPostProcessor.postProcessBeanFactory(): 所有bean定义加载后, bean实例前, 可优先实例业务bean
1. BeanPostProcessor: bean的初始化过程中执行
1. SmartInitializingSingleton.afterSingletonsInstantiated(): 所有bean初始化完成后执行, 可对bean再次进行调整


### [Spring容器创建过程](./src/main/java/com/tree/bootroad/v001spring/atguigu/s018contextinit/README.md)
SpringContext.refresh(): 容器创建并刷新

1. prepareRefresh(): context刷新前的预处理
1. obtainFreshBeanFactory(): 获取BeanFactory
1. prepareBeanFactory():  beanFactory 的预准备工作   
1. postProcessBeanFactory(): beanFactory 准备完成后, 进行的后置处理工作
1. invokeBeanFactoryPostProcessors(): 实例化并执行所有BeanFactoryPostProcessor  
1. registerBeanPostProcessors(): 注册BeanPostProcessor(bean初始化前后执行)
1. initMessageSource(): 初始化MessageSource组件(国际化功能, 消息绑定等)
1. initApplicationEventMulticaster(): 初始化事件派发器  
1. onRefresh(): 初始化其他特殊的bean
1. registerListeners(): 将容器中所有Listener交给ApplicationEventMulticaster
1. finishBeanFactoryInitialization(): 初始化所有剩下的单实例bean
1. finishRefresh(): 刷新完成后的操作
1. resetCommonCaches(): 重置一下缓存资源

总结:
1. Spring容器启动的时候, 先保存所有注册进来的Bean的定义信息
    - xml注册bean
    - 注解注册bean: @Bean @Service    
1. Spring容器会在合适的时机创建这些Bean
    - 用到bean的时候: getBean()创建并保存Bean
    - 统一创建剩下的单实例bean: finishBeanFactoryInitialization()
1. BeanPostProcessor 后置处理器
    - 每个bean创建过程中, 都会用到各种BeanPostProcessor, 增加bean的功能
    - AutowiredAnnotationBeanPostProcessor: 处理自动注入
    - AnnotationAwareAspectJAutoProxyCreator: 给bean创建代理对象(AOP)
    - AsyncAnnotationBeanPostProcessor: 支持异步注解
    - ScheduledAnnotationBeanPostProcessor: 支持调度功能
    - 其他后置处理器...
1. Spring容器的事件驱动
    - ApplicationListener: 接口
    - @EventListener: 注解
    - 派发器

## web
### servlet3.0
### 异步请求

