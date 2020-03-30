### ApplicationListener

监听容器中分布的事件, 事件驱动模型开发:
ApplicationListener 监听 ApplicationEvent 及其子事件

步骤:
1. 注册一个监听器(ApplicationListener)监听某事件(ApplicationEvent)
    - ApplicationListener的bean: 实现接口
    - @EventListener: 任何bean方法的添加注解
1. 只要容器中有相关事件发布, 就能监听到这事件
    - ContextRefreshedEvent: 容器刷新完成事件
    - ContextClosedEvent: 容器关闭事件
1. 发布事件 context.publishEvent()   

原理:
1.  ContextRefreshedEvent事件:
    - ApplicationContext.refresh(): 容器初始化
    - finishRefresh(): 发布 ContextRefreshedEvent
    
1. 事件发布流程(ApplicationContext中)
    - publishEvent()
        1. getApplicationEventMulticaster(): 获取事件派发器
        1. ApplicationEventMulticaster.multicastEvent(): 派发事件
            - getApplicationListeners(): 获取所有Listener
            - invokeListener(): 同步或者异步执行
            - doInvokeListener(): 具体执行
            - ApplicationListener.onApplicationEvent()
            
1. 事件派发器(ApplicationEventMulticaster)初始化
    - ApplicationContext.refresh()
    - initApplicationEventMulticaster(): 初始化事件派发器
    - 容器中已有用现有的, 否则默认使用 SimpleApplicationEventMulticaster      

1. 容器中的监听器(ApplicationListener)
    - ApplicationContext.refresh()
    - registerListeners(): 注册监听器
    - getBeanNamesForType(): 从容器中获取所有监听器
    - getApplicationEventMulticaster().addApplicationListenerBean(): 注册到派发器
    
    
@EventListener 原理    
使用 EventListenerMethodProcessor 解析 @EventListener
1. EventListenerMethodProcessor 实现 SmartInitializingSingleton
1. SmartInitializingSingleton.afterSingletonsInstantiated(): 在所有bean初始化完成后执行
    - ApplicationContext.refresh()
    - finishBeanFactoryInitialization(): 实例化容器中剩余的单实例
    - beanFactory.preInstantiateSingletons(): beanFactory具体的实例化
    - SmartInitializingSingleton.afterSingletonsInstantiated(): 所有bean实例化后触发

***SmartInitializingSingleton.afterSingletonsInstantiated() 在所有单实例初始化后执行***    