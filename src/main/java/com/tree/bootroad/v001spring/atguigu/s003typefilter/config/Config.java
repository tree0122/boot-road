package com.tree.bootroad.v001spring.atguigu.s003typefilter.config;

import com.tree.bootroad.v001spring.atguigu.s003typefilter.dao.BookDao;
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
 *
 * FilterType: FilterType.ASSIGNABLE_TYPE, 指定的类型
 * FilterType: FilterType.CUSTOM, 自定义规则类
 */
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s003typefilter", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookDao.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
public class Config {


}
