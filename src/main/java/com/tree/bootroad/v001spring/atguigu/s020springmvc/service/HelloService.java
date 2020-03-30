package com.tree.bootroad.v001spring.atguigu.s020springmvc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String say(String name){
        return "Hello " + name;
    }
}
