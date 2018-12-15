package com.tree.bootroad.cache;

import com.tree.bootroad.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SpringCache {

    @Cacheable
    public User getById(int id){
        return User.builder()
                .id(id)
                .name("tree")
                .age(18)
                .build();
    }

    @CacheEvict
    public void update(User user){

    }
}
