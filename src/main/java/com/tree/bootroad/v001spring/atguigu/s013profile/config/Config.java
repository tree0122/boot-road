package com.tree.bootroad.v001spring.atguigu.s013profile.config;

import com.tree.bootroad.v001spring.atguigu.s013profile.bean.DBSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * @Profile:
 *      Spring根据当前环境, 动态的激活和切换一系列组件
 *      写在配置类上, 仅指定的环境时, 整个配置类里的所有bean才生效
 *
 * @Profile:
 *      1. 指定组件在哪个环境下能注册到容器; 不指定, 任何环境下都能注册到容器
 *      2. 加了环境标示的bean, 只有这个环境下能被注册到容器, 默认为default
 *      3. vm参数(-Dspring.profiles.active=dev), 可命令行指定环境标识
 *      4. 代码的方式, context创建时指定其环境标识
 */
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s013profile")
public class Config {

    @Bean
    public DBSource dbDev(){
        DBSource db = new DBSource();
        db.setUsername("dev");
        db.setPassword("dev");
        return db;
    }

    @Profile("test")
    @Bean
    public DBSource dbTest(){
        DBSource db = new DBSource();
        db.setUsername("test");
        db.setPassword("test");
        return db;
    }

    @Profile("prod")
    @Bean
    public DBSource dbProd(){
        DBSource db = new DBSource();
        db.setUsername("prod");
        db.setPassword("prod");
        return db;
    }
}

