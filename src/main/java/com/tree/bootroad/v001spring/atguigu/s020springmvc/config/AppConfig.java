package com.tree.bootroad.v001spring.atguigu.s020springmvc.config;

import com.tree.bootroad.v001spring.atguigu.s020springmvc.interceptor.MyHandlerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * SpringMVC 子容器 仅扫描 @Controller: 子容器
 * includeFilters 和 useDefaultFilters, 配合使用
 */
@EnableWebMvc
@ComponentScan(
        value = "com.tree.bootroad.v001spring.atguigu.s020springmvc",
        includeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        },
        useDefaultFilters = false
)
public class AppConfig implements WebMvcConfigurer {

        /**
         * 配置视图解析器
         * @param registry
         */
        @Override
        public void configureViewResolvers(ViewResolverRegistry registry) {
//                registry.jsp();
                registry.jsp("web", ".jsp");
        }

        /**
         * 静态资源访问
         * @param configurer
         */
        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
                configurer.enable();
        }


        /**
         * 拦截器
         * @param registry
         */
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**");
        }
}
