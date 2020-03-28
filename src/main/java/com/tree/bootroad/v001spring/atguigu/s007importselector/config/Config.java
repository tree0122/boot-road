package com.tree.bootroad.v001spring.atguigu.s007importselector.config;

import com.tree.bootroad.v001spring.atguigu.s007importselector.bean.Color;
import com.tree.bootroad.v001spring.atguigu.s007importselector.bean.Red;
import com.tree.bootroad.v001spring.atguigu.s007importselector.cond.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * @Import: 快速导入组件, id是组件的全类名
 */
@Import({Color.class, Red.class, MyImportSelector.class})
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s007importselector")
public class Config {


}

