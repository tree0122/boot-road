### web servlet 3.0

1. 注册servlet: 
    - @WebServlet: 注解HttpServlet的子类
    - ServletContext.addServlet()
    - ServletRegistrationBean: SpringBoot
1. 注册filter
    - @WebFilter: 注解Filter的子类
    - ServletContext.addFilter()
    - FilterRegistrationBean: SpringBoot
1. 注册listener
    - @WebListener: 注解ServletContextListener的子类
    - ServletContext.addListener()
    - ServletListenerRegistrationBean: SpringBoot

#### 原理
servlet 3.0 共享库或者 运行时插件能力: shared libraries, runtimes pluggability

1. Servlet容器(Tomcat等)启动时, 会扫描当前应用中所有jar中的 ServletContainerInitializer
    - ServletContainerInitializer: javax.servlet.ServletContainerInitializer 
    - 这个类是 servlet 3.0的规范
1. 提供 ServletContainerInitializer 的实现类
    - jar中有相应实现类
    - jar中必须有这个文件 META-INF/services/javax.servlet.ServletContainerInitializer
    - 文件的内容是 ServletContainerInitializer实现类的全名
1. 启动并运行这个 ServletContainerInitializer 的实现 
1. ServletContainerInitializer的实现
    - 类上注解 @HandlesTypes: 注解中指定应用感兴趣的类(可取其子类 子接口等)
    - onStartup(): tomcat执行这个方法   