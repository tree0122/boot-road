### 组件注入

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

