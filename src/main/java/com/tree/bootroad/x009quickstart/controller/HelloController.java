package com.tree.bootroad.x009quickstart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping("index")
    public String index(){
        return "hello world";
    }

}
