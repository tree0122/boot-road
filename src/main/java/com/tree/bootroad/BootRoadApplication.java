package com.tree.bootroad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@MapperScan("com.tree.bootroad.x014mybatis.dao")
//@ComponentScan("com.tree.bootroad.v002springmvc")
@ComponentScan("com.tree.bootroad.v004springboot")
@SpringBootApplication
public class BootRoadApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootRoadApplication.class, args);
    }

}

