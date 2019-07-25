package com.chryl.cache;

import com.chryl.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Chryl on 2019/7/25.
 */
@Slf4j
@Component
public class RedisCache<K, V> implements Cache<K, V> {


    //cache前缀
    private final String CACHE_PREFIX = "Chryl-cache:";

    private byte[] getKey(K k) {
        if (k instanceof String) {
            return (CACHE_PREFIX + k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    @Resource
    private JedisUtil jedisUtil;

    @Override
    public V get(K k) throws CacheException {
        //
        log.info("从redis获取的数据");
        byte[] value = jedisUtil.get(getKey(k));
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        //-----------------------------
        //这个地方可以使用本地二级缓存,
        //没有必要每次都去redis去读取数据,
        //从redis读取,再放到本地缓存,
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(v);
        jedisUtil.set(key, value);
        jedisUtil.expire(key, 600);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = jedisUtil.get(key);
        jedisUtil.del(key);
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    @Override
    public void clear() throws CacheException {

        //clear不要重写,redis不仅仅存储 shiro的内容
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
