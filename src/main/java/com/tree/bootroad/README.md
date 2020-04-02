# SpringBoot


启动流程: 
1. 几个重要的事件回调机制
    - ApplicationContextInitializer
    - SpringApplicationRunListener
    - ApplicationRunner
    - CommandLineRunner
    
1. **创建 SpringApplication 对象**  
    在 SpringApplication 的构造方法:
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
        
1. **运行 run() 方法**  
    SpringApplication.run(): run方法
    ```java
    public ConfigurableApplicationContext run(String... args) {
    		ConfigurableApplicationContext context = null;
    		Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
    		// 设置head属性
 		    configureHeadlessProperty();
 		    // 从类路径下找到 META-INF/spring.factories文件中的所有 SpringApplicationRunListener, 然后保存 
    		SpringApplicationRunListeners listeners = getRunListeners(args);
 		    // 回调所有的 SpringApplicationRunListener.starting()
    		listeners.starting();
    		try {
 		        // 封装命令行参数
    			ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
 			    // 准备环境
	            // 回调环境已准备好 SpringApplicationRunListener.contextPrepared()
    			ConfigurableEnvironment environment = prepareEnvironment(listeners, applicationArguments);
    			configureIgnoreBeanInfo(environment);
    			Banner printedBanner = printBanner(environment);
 			    // 创建 SpringContext
    			context = createApplicationContext();
 			    // SpringBooot 异常上报
    			exceptionReporters = getSpringFactoriesInstances(SpringBootExceptionReporter.class,
    					new Class[] { ConfigurableApplicationContext.class }, context);
 			    // 准备 SpringContext
	            // 设置环境env
	            // 设置环境context的后置处理
	            // 执行所有ApplicationContextInitializer.initialize()
	            // 回调context准备完成
	            // 注册一些实例
	            // 生成 BeanDefinitionLoader, 并load() 注册当前配置类
	            // 回调context完成 SpringApplicationRunListener.contextLoaded()
    			prepareContext(context, environment, listeners, applicationArguments, printedBanner);
 			    // 刷新容器: ioc容器的初始化(web应用还创建嵌入式Tomcat)
    			refreshContext(context);
    			afterRefresh(context, applicationArguments);
 			    // 回调启动完成 SpringApplicationRunListener.started()
    			listeners.started(context);
 			    // 从容器中获取所有的 ApplicationRunner 和 CommandLineRunner
 			    // 先执行 ApplicationRunner.run(), 后 CommandLineRunner.run()
    			callRunners(context, applicationArguments);
    		}
    		catch (Throwable ex) {
    			handleRunFailure(context, ex, exceptionReporters, listeners);
    			throw new IllegalStateException(ex);
    		}
    		try {
 		        // 回调正在运行 SpringApplicationRunListener.running()
    			listeners.running(context);
    		}
    		catch (Throwable ex) {
    			handleRunFailure(context, ex, exceptionReporters, null);
    			throw new IllegalStateException(ex);
    		}
    		return context;
    	}
    ```
