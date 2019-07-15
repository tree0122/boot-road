package com.tree.bootroad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tree.bootroad.x014mybatis.dao")
@SpringBootApplication
public class BootRoadApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootRoadApplication.class, args);
    }

}

