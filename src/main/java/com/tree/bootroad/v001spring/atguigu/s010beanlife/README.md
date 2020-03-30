### Bean生命周期

生命周期: bean创建 -> 初始化 -> 使用 -> 销毁的过程 (容器管理bean的声明周期)
1. bean的创建(bean的构造方法, 反射实现)
    - 单例: 容器启动时创建
    - 多例: 获取时创建
1. 属性赋值
1. 初始化: bean构造方法后, 并对属性赋值, 然后调用初始化方法
    - @PostConstruct + @PreDestroy: bean的方法加上这两注解, InitDestroyAnnotationBeanPostProcessor实现
    - InitializingBean + DisposableBean: bean实现这两接口
    - @Bean(initMethod = "init", destroyMethod = "destroy")
    - BeanPostProcessor, bean的后置处理器
        - postProcessBeforeInitialization: 初始化之前
        - postProcessAfterInitialization: 初始化之后
1. 销毁: 
    - 单例: 容器关闭的时候
    - 多例: 容器不管理多例的销毁

