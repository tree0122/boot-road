### BeanFactoryPostProcessor BeanFactory后置处理器

- BeanPostProcessor: bean后置处理器, bean对象初始化前后工作
- BeanFactoryPostProcessor: BeanFactory后置处理器
- 时机: 在BeanFactory标准初始化后调用, 所有bean定义保存到BeanFactory, 但是bean实例未创建

#### 原理:
1. AnnotationConfigApplicationContext.refresh()
1. invokeBeanFactoryPostProcessors(): 
    - 从BeanFactory找到所有 BeanFactoryPostProcessor
    - 执行 BeanFactoryPostProcessor.postProcessBeanFactory()
    - 在创建其他组件之前执行

### BeanDefinitionRegistryPostProcessor BeanFactory后置处理器
1. postProcessBeanDefinitionRegistry(): 有bean定义将被加载, bean未创建
1. 先于BeanFactoryPostProcessor执行: 利用这个, 再给容器额外添加一下组件定义

#### 原理:
1. AnnotationConfigApplicationContext.refresh()
1. invokeBeanFactoryPostProcessors(): 
    - 从BeanFactory找到所有 BeanFactoryPostProcessor
    - 执行 BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()
    - 执行 BeanDefinitionRegistryPostProcessor.postProcessBeanFactory()
    - 执行其他 BeanFactoryPostProcessor