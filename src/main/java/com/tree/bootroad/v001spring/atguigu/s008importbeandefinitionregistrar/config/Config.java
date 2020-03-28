package com.tree.bootroad.v001spring.atguigu.s008importbeandefinitionregistrar.config;

import com.tree.bootroad.v001spring.atguigu.s008importbeandefinitionregistrar.bean.Color;
import com.tree.bootroad.v001spring.atguigu.s008importbeandefinitionregistrar.bean.Red;
import com.tree.bootroad.v001spring.atguigu.s008importbeandefinitionregistrar.cond.MyImportBeanDefinitionRegistrar;
import com.tree.bootroad.v001spring.atguigu.s008importbeandefinitionregistrar.cond.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * @Import: 快速导入组件, id是组件的全类名
 */
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s007importselector")
public class Config {


}

