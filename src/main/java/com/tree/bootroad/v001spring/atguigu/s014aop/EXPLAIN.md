### AOP原理解析
#### 重点:
1. 给容器注入什么组件
1. 组件的功能是什么
1. 组件什么时候工作

#### 核心: @EnableAspectJAutoProxy
1. @EnableAspectJAutoProxy
    - 通过@Import注入AspectJAutoProxyRegistrar
1. AspectJAutoProxyRegistrar
    - 向容器注入bd(AnnotationAwareAspectJAutoProxyCreator)
1. AnnotationAwareAspectJAutoProxyCreator
    - 是SmartInstantiationAwareBeanPostProcessor的后置处理器
1. AnnotationAwareAspectJAutoProxyCreator的重点方法
    - AbstractAdvisorAutoProxyCreator.setBeanFactory()
        - initBeanFactory(), 内部调用
    - AbstractAutoProxyCreator.postProcessBeforeInitialization()
    - AbstractAutoProxyCreator.postProcessAfterInitialization()
    - initBeanFactory()重写了

#### 流程

##### AnnotationAwareAspectJAutoProxyCreator的创建
1. 传入配置类(@Configuration), 创建ioc容器(AnnotationConfigApplicationContext)
1. 注册配置类, 调用refresh()刷新容器(AnnotationConfigApplicationContext)
    - register(annotatedClasses)
    - refresh()
        - 父类AbstractApplicationContext.refresh()
1. 父类(AbstractApplicationContext)注册所有BeanPostProcessor, 方便拦截bean的创建
    - registerBeanPostProcessors()注册BeanPostProcessor
        - PostProcessorRegistrationDelegate.registerBeanPostProcessors()按顺序注册所有后置处理器
            1. PriorityOrdered
            1. Ordered
            1. noOrdered
            1. internal(MergedBeanDefinitionPostProcessor的后置处理器)
1. beanFactory.getBean(beanName, BeanPostProcessor.class), 创建BeanPostProcessor实例
    - beanFactory默认类型是DefaultListableBeanFactory
    - doGetBean() 
    - createBean()
    - doCreateBean()
    - createBeanInstance(): 反射创建bean
    - populateBean(): bean属性赋值
    - initializeBean(): bean的初始化
        1. invokeAwareMethods(): aware接口方法(BeanFactory相关)
            - bean.setBeanFactory()执行的是AnnotationAwareAspectJAutoProxyCreator.setBeanFactory()
        1. applyBeanPostProcessorsBeforeInitialization(): BeanPostProcessor.beforeInitialization()
        1. invokeInitMethods(): 自定义初始化方法
        1. applyBeanPostProcessorsAfterInitialization(): BeanPostProcessor.afterInitialization()
1. AnnotationAwareAspectJAutoProxyCreator.setBeanFactory()
    - advisorRetrievalHelper: 从BeanFactory获取advisor的辅助类
    - aspectJAdvisorFactory: 从AspectJ类中创建advisor的工厂
    - aspectJAdvisorsBuilder: AnnotationAwareAspectJAutoProxyCreator的基础设施
1. 将BeanPostProcessor注册到BeanFactory

##### Aspect的Advisor(增强器)创建
创建时机: 除去BeanPostProcessor的bean为, 首个bean(一般为configBean)的创建过程, 大致流程参考bean的创建过程
1. beanFactory默认类型是DefaultListableBeanFactory
1. resolveBeforeInstantiation(): 给BeanPostProcessors创建proxy对象的机会
1. applyBeanPostProcessorsBeforeInstantiation(): InstantiationAwareBeanPostProcessors处理器在bean实例化前的处理
1. 进行到AnnotationAwareAspectJAutoProxyCreator时, 判断是否是增强类时shouldSkip()
1. AnnotationAwareAspectJAutoProxyCreator.findCandidateAdvisors(), 找出所有的增强类bd, 并生成相应增强器(通知方法)

##### 动态代理bean的创建
创建时机: 源生bean(非代理)的过程大致相同, 在initializeBean()时会转为动态代理对象
1. applyBeanPostProcessorsAfterInitialization(): BeanPostProcessors在bean初始化后的应用
1. AbstractAutoProxyCreator.postProcessAfterInitialization()时, 开始生成动态对象
1. wrapIfNecessary() 生成代理对象
    - getAdvicesAndAdvisorsForBean(): 获取时候bean的Advisors(并且按通知排序)
    - findEligibleAdvisors(): 运用PointCut的切点表达式
    - createProxy(): 生成具体的代理对象
        - ProxyFactory.getProxy()
            
##### 动态代理bean的方法执行过程
容器中保存的是bean的代理对象(cglib, jdkProxy), 这个bean保存了详细信息(增强器, 目标方法 等等)
1. DynamicAdvisedInterceptor.intercept(): 拦截目标方法
1. ProxyFactory.getInterceptorsAndDynamicInterceptionAdvice: 获取拦截器链
1. 生成CglibMethodInvocation对象, 并将目标对象, 目标方法, 拦截器链等信息传递给对象
1. 调用CglibMethodInvocation.proceed(), 拦截链式执行方法(拦截器链即每个通知方法)
    - MethodInterceptor.invoke()
    - invokeJoinpoint()
            