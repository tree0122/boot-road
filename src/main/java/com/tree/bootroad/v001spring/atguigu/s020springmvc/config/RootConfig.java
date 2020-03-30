package com.tree.bootroad.v001spring.atguigu.s020springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring 容器不扫描 @Controller: 父容器
 */
@ComponentScan(
        value = "com.tree.bootroad.v001spring.atguigu.s020springmvc",
        excludeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        }
)
public class RootConfig {
}
