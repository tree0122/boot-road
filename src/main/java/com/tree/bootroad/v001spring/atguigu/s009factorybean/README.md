### 组件添加

1. @ComponentScan + @Component: 自己的类
    - @Component
    - @Repository 
    - @Service 
    - @Controller
1. @Configuration + @Bean: 第三方包里的组件
1. @Import: 快速给容器导入一个组件
    - @Import(要导入的组件): id是组件的全类名
    - @ImportSelector: 返回需要的组件全类名数组
    - @ImportBeanDefinitionRegistrar: 手动注册bean到容器
1. FactoryBean(工厂Bean)
    - 默认获取的是FactoryBean.getObject()创建的对象
    - 要获取FactoryBean, 需在id前加&(eg: &factoryBean)


