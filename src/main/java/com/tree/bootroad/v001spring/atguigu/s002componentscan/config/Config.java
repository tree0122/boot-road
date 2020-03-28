package com.tree.bootroad.v001spring.atguigu.s002componentscan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ComponentScan:
 * value = "" 指定要扫描的包
 * excludeFilters = Filter[], 指定扫描时按照规则排除哪些组件
 * includeFilters = Filter[], 指定扫描时按照规则只需要哪些组件
 * useDefaultFilters = bool, 是否启用默认规则
 *
 * @ComponentScans: 多个 @ComponentScan
 */
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s002componentscan", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class Config {


}
