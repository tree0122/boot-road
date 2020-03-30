### Spring容器创建过程

SpringContext.refresh(): 容器创建并刷新

1. prepareRefresh(): context刷新前的预处理
    - initPropertySources(): 初始化一些属性, 子类自定义个性化属性
    - getEnvironment().validateRequiredProperties(): 属性校验
    - Set<ApplicationEvent> earlyApplicationEvents: 保存容器中早期事件 
      
1. obtainFreshBeanFactory(): 获取BeanFactory
    - refreshBeanFactory(): 刷新BeanFactory, 并设置BeanFactory的id
    - getBeanFactory(): 返回GenericApplicationContext.beanFactory对象
    - beanFactory: 生于GenericApplicationContext无参构造方法, 类型DefaultListableBeanFactory
    
1. prepareBeanFactory():  beanFactory 的预准备工作    
    - 设置beanFactory的类加载器, 支持表达式解析器 等等
    - 添加部分BeanPostProcessor: ApplicationContextAwareProcessor
    - 设置忽略的自动装配的接口: EnvironmentAware等等
    - 注册可以解析的自动装配(任何bean中自动注入): BeanFactory, ApplicationContext等等
    - 添加部分BeanPostProcessor: ApplicationListenerDetector
    - 添加编译时的AspectJ支持
    - 给beanFactory注册一下基础组件: beanFactory.registerSingleton()
        - environment: ConfigurableEnvironment
        - systemProperties: Map
        - systemEnvironment: Map
        
1. postProcessBeanFactory(): beanFactory 准备完成后, 进行的后置处理工作
    - 大部门情况为空方法
    - 子类可重新此方法, 对beanFactory进一步设置

1. invokeBeanFactoryPostProcessors(): 实例化并执行所有BeanFactoryPostProcessor  
    - BeanFactoryProcessor: beanFactory标准初始化后执行
    - BeanDefinitionRegistryPostProcessor: 
        - PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors()
            - postProcessBeanDefinitionRegistry()
        - PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors()
            - postProcessBeanFactory
        - 执行顺序
            - PriorityOrdered          
            - Ordered
            - 普通
    - BeanFactoryPostProcessor:  
        - PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors()
            - postProcessBeanFactory
        - 执行顺序
            - PriorityOrdered          
            - Ordered
            - 普通     

1. registerBeanPostProcessors(): 注册BeanPostProcessor(bean初始化前后执行)
    - BeanPostProcessor的不同类型: 在bean创建中的执行时机不一样
        - MergedBeanDefinitionPostProcessor:  bean反射创建对象以后, 最后机会处理bean定义
        - InstantiationAwareBeanPostProcessor: bean实例化前后都执行, 先于bean属性赋值
        - SmartInstantiationAwareBeanPostProcessor: 同上, 增加对bean的判断
        - BeanPostProcessor: bean初始化前后
        - DestructionAwareBeanPostProcessor: bean销毁之前
    - PostProcessorRegistrationDelegate.registerBeanPostProcessors()
    - beanFactory.addBeanPostProcessor(BeanPostProcessorChecker): 这个处理器检查其他处理器
    - 注册所有BeanPostProcessor
        - 执行顺序
            - PriorityOrdered          
            - Ordered
            - 普通
            - internal: MergedBeanDefinitionPostProcessor的处理器
    - beanFactory.addBeanPostProcessor(ApplicationListenerDetector): 检查是不是Listener

1. initMessageSource(): 初始化MessageSource组件(国际化功能, 消息绑定等)
    - getBeanFactory(): 获取BeanFactory
    - 默认 DelegatingMessageSource
    - 注册到容器

1. initApplicationEventMulticaster(): 初始化事件派发器   
    - getBeanFactory(): 获取BeanFactory
    - 默认 SimpleApplicationEventMulticaster
    - 注册到容器   

1. onRefresh(): 初始化其他特殊的bean
    - 默认空方法  
    - 子类可重新此方法, 自定义一写bean初始化逻辑
    
1. registerListeners(): 将容器中所有Listener交给ApplicationEventMulticaster
    - Listener 暂未实例化
    - 从容器中获取所有定义了ApplicationListener的名字
    - getApplicationEventMulticaster().addApplicationListenerBean(): 交给派发器
    - earlyApplicationEvents不为null: 派发早期事件

1. finishBeanFactoryInitialization(): 初始化所有剩下的单实例bean
    - 尝试实例化 ConversionService (类型转换组件)
    - 实例化 StringValueResolver (值解析器)
    - 实例化 LoadTimeWeaverAware
    - beanFactory.setTempClassLoader()
    - beanFactory.freezeConfiguration(): 缓存所有bean定义, 不需定义再被修改
    - [beanFactory.preInstantiateSingletons()](./preInstantiateSingletons.md): 实例化剩余的单实例

1. finishRefresh()
    - clearResourceCaches(): 清除扫描的resource
    - initLifecycleProcessor(): 初始化LifecycleProcessor(容器启动完成后的bean触发的操作)
    - getLifecycleProcessor().onRefresh(): 启动所有SmartLifecycle.start()
    - publishEvent(): 发布容器刷新事件
    - LiveBeansView.registerApplicationContext()

1. resetCommonCaches(): 重置一下缓存资源                