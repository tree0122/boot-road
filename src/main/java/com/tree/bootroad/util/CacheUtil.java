package com.tree.bootroad.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class CacheUtil {

    public static Cache guavaCache(){
        Cache<Object, Object> cache = CacheBuilder.newBuilder()
                .initialCapacity(1000)
                .maximumSize(1000)
                .expireAfterAccess(60, TimeUnit.SECONDS)
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build();

        return cache;
    }

    public static LoadingCache guavaLoadingCache(){
        return CacheBuilder.newBuilder()
                .initialCapacity(1000)
                .maximumSize(1000)
                .expireAfterAccess(60, TimeUnit.SECONDS)
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build(new CacheLoader<Object, Object>() {
                    @Override
                    public Object load(Object key) throws Exception {

                        return null;
                    }
                });
    }

}
