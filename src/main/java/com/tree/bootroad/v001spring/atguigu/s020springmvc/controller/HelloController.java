package com.tree.bootroad.v001spring.atguigu.s020springmvc.controller;

import com.tree.bootroad.v001spring.atguigu.s020springmvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        String res = helloService.say("tomcat");
        return res;
    }
}
