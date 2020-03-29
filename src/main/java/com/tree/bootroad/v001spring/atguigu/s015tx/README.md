### 声明式事务

#### 使用步骤:
1. 导入相关依赖(数据源, 数据库驱动, spring-jdbc)
1. 配置数据源, JdbcTemplate
1. 给方法上标注@Transactional, 表示此方法是一个事务方法
1. @EnableTransactionManagement: 开启基于注解的事务
1. 配置事务管理器 PlatformTransactionManager

#### 原理:
1. @EnableTransactionManagement
    - 利用 TransactionManagementConfigurationSelector导入两个组件
        - AutoProxyRegistrar
        - ProxyTransactionManagementConfiguration
1. AutoProxyRegistrar: 
    - 给容器注册InfrastructureAdvisorAutoProxyCreator(BeanPostProcessor)
    - 利用BeanPostProcessor, 在增强Bean, 返回一个代理对象
1. ProxyTransactionManagementConfiguration
    - 给容器注册事务增强器 BeanFactoryTransactionAttributeSourceAdvisor
    - 事务注解信息解析器 AnnotationTransactionAttributeSource
    - 事务拦截器 TransactionInterceptor: 保存事务属性, 事务管理器
        - 在目标方法执行的时候: 执行事务拦截链 invokeWithinTransaction()
        - 获取事务相关属性 TransactionAttribute
        - 获取事务管理器 PlatformTransactionManager
        - 执行目标方法
            - 如果异常, 通过tm回滚
            - 如果正常, 通过tm提交