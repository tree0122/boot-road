package com.tree.bootroad.x002aop.service;

import com.tree.bootroad.x002aop.annotation.LogCost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EntityService {

    public String save(String user){
        log.info("===========保存");
        return user;
    }

    public String get(String user){
        log.info("===========查询");
        return user;
    }

    @LogCost
    public String log(String user){
        log.info("===========log");
        return user;
    }
}
