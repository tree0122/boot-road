package com.tree.bootroad.cache;

import com.tree.bootroad.model.User;
import com.tree.bootroad.util.CacheUtil;
import org.springframework.stereotype.Service;

@Service
public class GuavaCache {

    public User getById(int id){
        return (User) CacheUtil.guavaCache().getIfPresent(id);
    }

}
