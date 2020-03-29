package com.tree.bootroad.v001spring.atguigu.s015tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "INSERT INTO `user`(name, age) VALUES (?, ?)";

        jdbcTemplate.update(sql, "tree", 19);
    }

}
