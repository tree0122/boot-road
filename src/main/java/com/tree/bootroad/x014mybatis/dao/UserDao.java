package com.tree.bootroad.x014mybatis.dao;

import com.tree.bootroad.x014mybatis.model.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> listAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getById(Long id);

    @Insert("INSERT INTO users (name, nick_name) VALUES (#{name}, #{nickName})")
    void insert(UserEntity userEntity);

    @Update("UPDATE users SET name = #{name}, nick_name = #{nickName} WHERE id = #{id}")
    void update(UserEntity userEntity);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id);
}
