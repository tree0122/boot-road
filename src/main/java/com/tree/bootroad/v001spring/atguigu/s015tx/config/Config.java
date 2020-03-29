package com.tree.bootroad.v001spring.atguigu.s015tx.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * 声明式事务:
 * 1. 导入相关依赖
 *      数据源, 数据库驱动, spring-jdbc
 * 2. 配置数据源, JdbcTemplate
 * 2. 给方法上标注@Transactional, 表示此方法是一个事务方法
 * 4. @EnableTransactionManagement: 开启基于注解的事务
 * 5. 配置事务管理器 PlatformTransactionManager
 */
@EnableTransactionManagement
@Configuration
@ComponentScan(value = "com.tree.bootroad.v001spring.atguigu.s015tx")
public class Config {

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("");
        dataSource.setPassword("");
//        dataSource.setDriverClass("");
        dataSource.setJdbcUrl("");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}

