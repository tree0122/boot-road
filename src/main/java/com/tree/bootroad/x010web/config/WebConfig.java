package com.tree.bootroad.x010web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@Slf4j
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.setName("MyFilter");
        bean.addUrlPatterns("/*");
        bean.addInitParameter("paramName", "paramValue");
        bean.setOrder(1);
        return bean;
    }

    public class MyFilter implements Filter{

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            Enumeration<String> names = filterConfig.getInitParameterNames();
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            log.info("this is my filter, url: {}", req.getRequestURL());
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {

        }
    }

}
