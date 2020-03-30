package com.tree.bootroad.v001spring.atguigu.s020springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Tomcat等容器启动时创建对象
 * 调用 onStartup(): 初始化容器 以及 前端控制器
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 获取根容器的配置类(类似 Spring的配置文件): 父容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 获取web容器的配置类(SpringMVC配置文件): 子容器
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * 获取 DispatchServlet(前端控制器)的映射信息
     *
     *  / : 拦截所有请求(包括静态资源, 不包括 *.jsp)
     *  /* :拦截所有请求(包含 *.jsp), jsp页面由tomcat的jsp引擎解析
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
