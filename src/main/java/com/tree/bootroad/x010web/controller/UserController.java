package com.tree.bootroad.x010web.controller;

import com.tree.bootroad.x010web.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public User get(){
        return User.builder()
                .name("xiaoMing")
                .password("xxxxx")
                .build();
    }

}
