### web springMVC

1. spring-web的jar下, 有META-INF/services/javax.servlet.ServletContainerInitializer
1. tomcat等web容器启动时, 会扫描每个jar包下的META-INF/services/javax.servlet.ServletContainerInitializer
1. 加载这个文件中的类 SpringServletContainerInitializer
1. Spring应用一启动, 会加载感兴趣的 WebApplicationInitializer 接口下的所有组件
1. 为 WebApplicationInitializer 组件创建对象(非接口 非抽象类)
    - AbstractContextLoaderInitializer.createRootApplicationContext(): 创建根容器
    - AbstractDispatcherServletInitializer
        - createServletApplicationContext(): web容器
        - createDispatcherServlet(): DispatcherServlet
        - registerDispatcherServlet(): 将 DispatcherServlet 添加到 ServletContext
    - AbstractAnnotationConfigDispatcherServletInitializer: 注解方式配置
        - getRootConfigClasses(): 根容器时, 传入配置类
        - getServletConfigClasses(): web容器时, 传入配置类

总结: 
1. 注解方式配置SpringMVC: 实现 AbstractAnnotationConfigDispatcherServletInitializer
1. 实现抽象方法指定 DispatcherServlet 的配置信息


定制SpringMVC
1. @EnableWebMvc: 开启SpringMVC定制配置功能(标签 mvc:annotation-driven )    
1. 配置组件(视图解析器, 视图映射, 静态资源映射, 拦截器...)
1. java配置类 实现 WebMvcConfigurer    
 