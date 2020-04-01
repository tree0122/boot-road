### HandlerAdapter.handle(): 执行处理器方法, 返回mv

前置流程: DispatcherServlet.doDispatch() 起始, 主角 RequestMappingHandlerAdapter
1. handle(): 实际调用处理器
1. invokeHandlerMethod(): 调用处理器方法
1. ServletHandlerMethodInvoker.invokeHandlerMethod(): 关键方法
1. ServletHandlerMethodInvoker.getModelAndView(): 获取mv
1. ServletHandlerMethodInvoker.updateModelAttributes(): 更新mode属性
1. 返回mv

invokeHandlerMethod() 具体流程: ServletHandlerMethodInvoker.invokeHandlerMethod()
1. 处理器上@SessionAttributes关注的Session:
    - 遍历Session域属性, 将Session域需要的找出
    - 将需要的Session内容, 放入请求域的ExtendedModelMap
1. 处理器中 @ModelAttribute 注解的方法
    - 在处理器中找到所有加这注解的方法, 并反射执行这些方法
    - resolveHandlerArguments(): 从request中找到这个方法所需的参数
    - Method.invoke(): 反射执行方法
    - 有返回结果, 则放入 ExtendedModelMap: key = 返回类型, value = 返回值
1. 开始目标方法
    - resolveHandlerArguments(): 从request中找到这个方法所需的参数
    - Method.invoke(): 反射执行方法
    - 返回目标方法结果

resolveHandlerArguments()具体流程: ServletHandlerMethodInvoker.resolveHandlerArguments()
1. 找到所有参数类型
1. 遍历这个参数数组, 找到每个参数对应的 name/value
    - 对应普通注解, 直接从Request中获取
        - @RequestParam
        - @RequestHeader
        - @RequestBody
        - ...
    - 对应 @ModelAttribute 和没有注解的参数(POJO)
        - resolveModelAttribute(): 生成WebDataBinder(包含new POJO())
            - WebDataBinder.objectName: key
            - WebDataBinder.target: value
        - doBind(): 将Request中的值 与POJO的属性进行绑定
        - 将收集到的参数key/value 放入 ExtendedModelMap
1. 返回参数数组        
        

### SpringMVC 确定目标方法POJO入参的过程 resolveModelAttribute()
1. 具体在 HandlerMethodInvoker.resolveModelAttribute()
1. Conventions.getVariableNameForParameter(): 默认 key=类名
1. 获取对应value
    - 尝试从 ExtendedModelMap 获取value
    - 若处理器标注 @SessionAttributes, 尝试中Session中获取
    - BeanUtils.instantiateClass(): 没有value, 则反射生成
1. createBinder(): 以 key/value 生成 WebDataBinder
1. initBinder(): 初始化 @InitBinder 相关
1. 返回binder