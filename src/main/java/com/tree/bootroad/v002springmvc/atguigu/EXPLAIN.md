# SpringMVC 流程和原理

### 源码分析(SpringBoot)

1. DispatcherServlet.doService(): 前端控制器入口, 预处理工作
    - HttpServletRequest.setAttribute(): 添加一些context, resolver
1. doDispatch(): 开始进入请求
1. getHandler(): 获取相应的 HandlerExecutionChain
    - 获取所有的 HandlerMapping 实例: beanFactory.getBean()
        - SimpleUrlHandlerMapping: faviconHandlerMapping
        - RequestMappingHandlerMapping: requestMappingHandlerMapping
        - BeanNameUrlHandlerMapping: beanNameHandlerMapping
        - SimpleUrlHandlerMapping: resourceHandlerMapping(处理静态资源)
        - WelcomePageHandlerMapping: welcomePageHandlerMapping
    - 遍历并执行 HandlerMapping.getHandler(), 尝试得到 HandlerExecutionChain
        - 添加满足条件的Interceptor
    - HandlerExecutionChain 不为null, 直接返回
1. getHandlerAdapter(): 获取相应的 HandlerAdapter
    - 获取所有的 HandlerAdapter 实例: beanFactory.getBean()
        - RequestMappingHandlerAdapter
        - HttpRequestHandlerAdapter
        - SimpleControllerHandlerAdapter
    - 遍历并执行的满足条件的 HandlerAdapter
1. HandlerExecutionChain.applyPreHandle(): 控制器方法前的拦截器处理
    - 获取所有符合条件的 HandlerInterceptor
    - 顺序执行 HandlerInterceptor.preHandle()
1. [HandlerAdapter.handle()](./handle.md): 执行控制器方法
1. HandlerExecutionChain.applyPostHandle(): 控制器方法后的拦截器处理
    - 获取所有符合条件的 HandlerInterceptor
    - 逆序执行 HandlerInterceptor.postHandle()
1. processDispatchResult(): 处理正常和异常视图
    - processHandlerException(): 异常处理
    - [render()](./render.md): 渲染视图
    - HandlerExecutionChain.triggerAfterCompletion(): 渲染后的拦截器处理
        - 获取所有符合条件的 HandlerInterceptor
        - 逆序执行 HandlerInterceptor.afterCompletion()