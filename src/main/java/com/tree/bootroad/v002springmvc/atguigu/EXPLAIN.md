# SpringMVC 流程和原理

### 请求流程:
1. 客户端发起请求
1. SpringMVC中是否存在对应映射
    - 不存在尝试走静态资源逻辑
        - 开启 DefaultServletHandler
            - 找到目标静态资源, 返回
            - 未找到 404页面
        - 未开启
            - 控制台打印 No mapping found
            - 404页面
    - 存在走DispatcherServlet逻辑
        - 由 HandlerMapping 获取 HandlerExecutionChain 对象
            - HandlerMapping: 请求到处理器的映射
            - HandlerExecutionChain: 处理执行链
                - 具体的处理方法
                - 拦截器链
        - 获取适合Handler的 HandlerAdapter 对象: 处理方法的适配器
            - 具体的处理方法
            - 方法参数等的一些处理逻辑
        - 拦截器 HandlerInterceptor.preHandle(): 通过 HandlerExecutionChain.applyPreHandle()
        - 处理器的目标方法, 得到mv: 通过 HandlerAdapter.handle()
        - 拦截器 HandlerInterceptor.postHandle(): 通过 HandlerExecutionChain.applyPostHandle()
            - 拦截有异常
            - 由 HandlerExceptionResolver 组件处理异常, 得到新的 mv对象
        - 由ViewResolver组件根据mv对象得到实际的view
        - render(): 渲染视图
        - 拦截器 HandlerInterceptor.afterCompletion(): HandlerExecutionChain.triggerAfterCompletion()            
  