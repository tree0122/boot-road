### 详解beanFactory.preInstantiateSingletons()

1. 获取所有定义完成的bean, 然后遍历
1. getMergedLocalBeanDefinition(): 获取bean的定义信息
1. 只处理bean(单实例, 非抽象, 非懒加载)
    - FactoryBean
    - 普通bean
1. FactoryBean的实例
    - getBean(beanName): 实例化工厂bean
    - 需 FactoryBean调用: FactoryBean.getObject() 实例化产品bean
1. 普通bean的实例: getBean(beanName)
1. 所有bean初始化后的操作: SmartInitializingSingleton.afterSingletonsInstantiated()

#### getBean(beanName)详解: 返回bean实例
1. doGetBean(): 
1. transformedBeanName(name): 获取beanName
    - &beanName: factoryBean的id
    - beanName: 普通bean的id
1. getSingleton(beanName): 获取缓存中保存的bean
    - singletonObjects: 最终保存bean的Map
    - earlySingletonObjects: 半成品bean(bean的属性未赋值)的Map
    - singletonFactories: 单实例工厂(bean反射生成后, 带处理方法的工厂)的Map
1. singletonObjects有对应bean:
    - getObjectForBeanInstance(): 获取真正的bean
        - &beanName: 表示获取factoryBean实例, 直接返回bean
        - BeanType非FactoryBean: 直接返回bean     
        - BeanType是FactoryBean: 
            - getObjectFromFactoryBean():
                - doGetObjectFromFactoryBean(): FactoryBean.getObject()获取bean
                - beforeSingletonCreation():
                - postProcessObjectFromFactoryBean():
                    - applyBeanPostProcessorsAfterInitialization(): BeanPostProcessor后置处理
                - afterSingletonCreation():
            - 放入factoryBeanObjectCache缓存
1. getSingleton(beanName, ObjectFactory): 缓存里没有, 直接创建
    - beforeSingletonCreation()
    - ObjectFactory.getObject(): 就是这个创建方法 createBean()
    - afterSingletonCreation()
    - addSingleton(): 放入缓存  
1. getObjectForBeanInstance(): 返回真正的bean(即使FactoryBean 首次创建也原样返回)    
    
#### createBean()详解: 返回bean实例
1. resolveBeforeInstantiation(): 在bean创造之前, 给BeanPostProcessor执行的机会
    - applyBeanPostProcessorsBeforeInstantiation(): 
        - 找到所有 InstantiationAwareBeanPostProcessor 组件
        - InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation
        - 直到返回不为null
    - applyBeanPostProcessorsAfterInitialization(): 上面不为null, 则执行
        - 找到所有 BeanPostProcessor 组件
        - 所有 BeanPostProcessor.postProcessAfterInitialization()
    - 上步不为null, 直接返回bean
1. 具体执行的是 doCreateBean()
1. factoryBeanInstanceCache.remove(beanName): 删除factoryBean缓存         
1. createBeanInstance(): 反射生成bean 
    - @Bean: instantiateUsingFactoryMethod() 配置类中的方法生成
    - 无参构造方法: autowireConstructor()
    - 有参构造方法: autowireConstructor()
1. applyMergedBeanDefinitionPostProcessors():
    - 找出所有MergedBeanDefinitionPostProcessor: BeanPostProcessor
    - MergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition(): 执行方法
1. addSingletonFactory(): 支持提前暴露, 则放入singletonFactories(bean提前暴露缓存)
    - getEarlyBeanReference(): ObjectFactory的具体生成方法
    - 找出所有 SmartInstantiationAwareBeanPostProcessor
    - SmartInstantiationAwareBeanPostProcessor.getEarlyBeanReference(): 执行方法  
1. populateBean(): bean属性赋值
    - 执行所有 InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation()
    - autowireByName() 或者 autowireByType(): 找到注入的bean
    - InstantiationAwareBeanPostProcessor.postProcessProperties()
    - InstantiationAwareBeanPostProcessor.postProcessPropertyValues()
    - applyPropertyValues(): 正式赋值操作
1. initializeBean(): 初始化bean  
    - invokeAwareMethods(): BeanFactoryAware相关接口
        - BeanNameAware
        - BeanClassLoaderAware
        - BeanFactoryAware
    - applyBeanPostProcessorsBeforeInitialization(): 所有BeanPostProcessor.postProcessBeforeInitialization()
        - ApplicationContextAwareProcessor: 处理ApplicationContext相关的赋值
        - EnvironmentAware
        - EmbeddedValueResolverAware
        - ResourceLoaderAware
        - ApplicationEventPublisherAware
        - MessageSourceAware
        - ApplicationContextAware
    - invokeInitMethods(): 自定义初始化方法
        - InitializingBean.afterPropertiesSet()
        - invokeCustomInitMethod(): @Bean(initMethod = "init")的init()
    - applyBeanPostProcessorsAfterInitialization(): 所有BeanPostProcessor.postProcessAfterInitialization()
1. registerDisposableBeanIfNecessary(): 根据需要注册为disposable
    - registerDisposableBean(): 放入 disposableBeans(LinkedListMap)          