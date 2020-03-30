### 异步请求
多种方式:
1. @WebServlet: servlet源生态
    - 注解中 asyncSupported = true: 支持异步
    - HttpServletRequest.startAsync(): 开启异步, 并获取asyncContext(异步上下文)
    - asyncContext.start(Runnable): 业务逻辑异步处理
    - asyncContext.getResponse(): 获取响应
1. Callable: @Controller的方法返回 Callable
    - 控制器返回 Callable
    - Spring异步处理, 将Callable给TaskExecutor的隔离线程执行
    - DispatcherServlet和所有Filter退出Tomcat容器线程, 但response保持打开
    - Callable返回结果, SpringMVC将请求重新给Tomcat容器, 回复之前的处理
    - 根据Callable的结果, SpringMVC从请求开始 - 视图渲染, 一步步执行
1. DeferredResult: @Controller的方法返回 DeferredResult
1. 异步拦截器:
    - AsyncListener: servlet 原生
    - SyncHandlerInterceptor: MVC中的
    