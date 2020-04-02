package com.tree.bootroad.v004springboot.atguigu.starter.Controller;

import com.tree.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/he")
    public String he(){
        return helloService.say(" he ");
    }

}
