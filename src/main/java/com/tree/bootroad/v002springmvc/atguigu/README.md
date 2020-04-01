# [SpringMVC](./EXPLAIN.md)

### 使用步骤:
1. @Controller: 标记组件为控制器
1. @RequestMapping: 标记控制器方法上, 表示映射请求的URI
1. InternalResourceViewResolver: 视图解析器
    - 将方法返回值, 解析为实际的物理视图
    - prefix + returnVal + suffix, 定位到物理视图
    - 转发操作

### 注解
1. @RequestMapping: 为控制器指定可以处理哪些URI请求
    - 类和方法上都快标注
    - 类定义: 初步的请求映射
    - 方法定义: 进一步的细分映射
    - DispatcherServlet截获请求后, 通过控制器上@RequestMapping, 确定对应的方法
    - @RequestMapping的属性:
        - value: 请求URI
        - method: 请求方法
        - params: 请求参数(不常用), 如{"field1", "field2==10"}
        - heads: 请求头(不常用)
    - 请求支持Ant风格的匹配符
        - ?: 一个字符
        - *: 多个字符
        - **: 多层路径  
1. @PathVariable: 可以将URI中的占位符参数, 绑定到控制器方法的入参中
    - URI中{xxx}
    - @PathVariable("xxx")
1. @RequestParam: 映射请求参数    
1. @RequestHeader: 映射请求头
1. @CookieValue: 处理方法入参绑定某个Cookie值
1. 请求参数名和POJO属性名进行自动匹配, 自动为该对象填充属性值, 支持级联
1. 方法的参数, 支持的Servlet类型的参数:
    - HttpServletRequest
    - HttpServletResponse
    - HttpSession
    - java.security.Principal
    - Locale
    - InputStream / OutputStream
    - Reader / Writer
1. 输出模型数据(ModelAndView):
    - ModelAndView:  方法返回值类型, 包含视图信息和模型信息
    - Map + Model: 入参Map和Model, 方法返回时Map中数据添加到Model
    - @SessionAttributes: 将模型中的某属性暂存到HttpSession
    - @ModelAttribute: 入参被标注后, 会被放到数据模型   
1. HiddenHttpMethodFilter: 浏览器form 发送 PUT 和 DELETE请求
    - 实例化并配置 HiddenHttpMethodFilter       
    - 发送POST请求
    - form携带隐藏域: name = "_method", value = "DELETE / PUT" 
1. @InitBinder: BinderData的绑定    

### 标准HTTP请求报头:
1. 请求行: 请求方法(POST GET) + 请求URI + HTTP协议及版本(HTTP/1.1)
1. 请求头: 
1. 请求体: 参数 

### REST
1. Resources(资源): 网络上的实体
1. Representation(表现层): 把资源呈现出来的形式   
1. State Transfer(状态转化): 表现层状态转化
    - POST: 新建      /order
    - GET: 获取       /order/1    <=>     get?id=1
    - PUT: 更新       /order/1    <=>     update?id=1
    - DELETE: 删除    /order/1    <=>     delete?id=1 

### Spring整合SpringMVC可能的问题
1. 整合时, 是否需要加入Spring的IOC容器; 是否需要在web.xml中配置启动Spring容器的 ContextLoaderListener    
    - 需要, 数据源 事务等放在Spring
    - 不需要, SpringMVC的配置文件通过 标签import 导入Spring的配置
1. Spring容器和SpringMVC容器扫描的包有重合部分, 导致bean被创建两次
    - 分别扫描不同的包
    - 使用 exclude-filter 和 include-filter: 规定指定的规则
1. 父子容器: Spring容器是父容器, SpringMVC容器是子容器
    - Spring容器不可以使用SpringMVC的bean(对应beans.xml)        
    - SpringMVC容器可以使用Spring的bean(对应springmvc.xml)        
         