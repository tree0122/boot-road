package com.tree.bootroad.controller;

import com.tree.bootroad.aop.annotation.LogCost;
import com.tree.bootroad.cache.GuavaCache;
import com.tree.bootroad.cache.SpringCache;
import com.tree.bootroad.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    private GuavaCache guavaCache;

    @Resource
    private SpringCache springCache;

    @GetMapping("{id}")
    @LogCost("get")
    public User get(@PathVariable("id") Integer id){
        log.info("get, id: {}", id);
        User user = springCache.getById(id);
        return user;
    }
}
