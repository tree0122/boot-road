# SpringBoot

启动流程: 
1. **创建 SpringApplication**
    ```java
    public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
        this.resourceLoader = resourceLoader;
        Assert.notNull(primarySources, "PrimarySources must not be null");
        // 保存主配置类
        this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
        // web应用类型
        this.webApplicationType = WebApplicationType.deduceFromClasspath();
        // 从类路径下找到 META-INF/spring.factories文件中的所有 ApplicationContextInitializer, 然后保存
        setInitializers((Collection) getSpringFactoriesInstances(ApplicationContextInitializer.class));
        // 从类路径下找到 META-INF/spring.factories文件中的所有 ApplicationListener, 然后保存
        setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
        // 从多个配置类中找到有main()的主配置类
        this.mainApplicationClass = deduceMainApplicationClass();
    }
    ```
        
1. ### 运行 run() 方法
