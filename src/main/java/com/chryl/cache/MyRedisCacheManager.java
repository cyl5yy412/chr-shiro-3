package com.chryl.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * Created by Chryl on 2019/7/25.
 */
public class MyRedisCacheManager implements CacheManager {


    @Resource
    private RedisCache redisCache;


    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
