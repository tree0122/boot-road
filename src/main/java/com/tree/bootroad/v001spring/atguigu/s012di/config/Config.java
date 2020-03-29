package com.tree.bootroad.v001spring.atguigu.s012di.config;

import com.tree.bootroad.v001spring.atguigu.s012di.Dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Autowired: 自动注入
 *     1. 默认优先按类型注入
 *     2. 如果有多个同类型组件, 再按id注入
 *     3. @Qualifier指定装配的组件id
 *     4. 自动装配默认默认属性, 否则报错. @Autowired(required=false)可解决
 *     5. @Primary: 装配时默认首先bean
 */
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s012di")
public class Config {

//    @Primary
    @Bean
    public BookDao bookDao2(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}

