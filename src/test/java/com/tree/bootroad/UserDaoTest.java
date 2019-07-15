package com.tree.bootroad;

import com.tree.bootroad.x014mybatis.dao.UserDao;
import com.tree.bootroad.x014mybatis.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void insert(){
        userDao.insert(new UserEntity(null, "cui", "xiaoCui"));
        userDao.insert(new UserEntity(null, "nly", "nee"));
        userDao.insert(new UserEntity(null, "lanyee", "lan"));

        int size = userDao.listAll().size();
        Assert.assertEquals(3, size);
    }

    @Test
    public void get(){
        List<UserEntity> list = userDao.listAll();
        log.info("users: {}", list);
    }

    @Test
    public void update(){
        userDao.update(new UserEntity(1L, "cui1", "null"));
        UserEntity userEntity = userDao.getById(1L);
        log.info("user: {}", userEntity);
    }
}
