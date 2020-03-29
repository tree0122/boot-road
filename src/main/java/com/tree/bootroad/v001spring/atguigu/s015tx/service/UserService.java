package com.tree.bootroad.v001spring.atguigu.s015tx.service;

import com.tree.bootroad.v001spring.atguigu.s015tx.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insert(){
        userDao.insert();
        log.info("insert success...");
    }
}
