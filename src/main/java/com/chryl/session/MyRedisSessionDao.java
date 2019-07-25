package com.chryl.session;

import com.chryl.utils.JedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chryl on 2019/7/25.
 */
@Slf4j
@Component
public class MyRedisSessionDao extends AbstractSessionDAO {


    @Resource
    private JedisUtil jedisUtil;
    //session前缀
    private final String SHIRO_SESSION_PREFIX = "Chryl-session:";

    //redis存储2进制的方式存储session
    private byte[] getKey(String key) {
        //前缀+session
        return (SHIRO_SESSION_PREFIX + key).getBytes();//二级制
    }

    //保存session
    private void saveSession(Session session) {
        if (session != null && session.getId() != null) {

        }
        //redis key 前缀+session,getId
        byte[] key = getKey(session.getId().toString());
        //redis value保存sesson对象
        byte[] value = SerializationUtils.serialize(session);
        jedisUtil.set(key, value);
        jedisUtil.expire(key, 600);
    }

    //创建
    @Override
    protected Serializable doCreate(Session session) {//创建session
        Serializable sessionId = generateSessionId(session);
        //捆绑 session和sessionId
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    //获取
    @Override
    protected Session doReadSession(Serializable sessionId) {
        //测试redis访问次数
        log.info("测试redis访问次数:{}","read session");
        //获得session
        if (sessionId == null) {
            return null;
        }
        byte[] key = getKey(sessionId.toString());
        byte[] value = jedisUtil.get(key);
        //反序列化获得session对象
        return (Session) SerializationUtils.deserialize(value);
    }

    //更新
    @Override
    public void update(Session session) throws UnknownSessionException {

        //存入redis
        if (session != null && session.getId() != null) {
            saveSession(session);
        }
    }

    //删除
    @Override
    public void delete(Session session) {

        if (session == null || session.getId() == null) {
            return;
        }
        byte[] key = getKey(session.getId().toString());
        jedisUtil.del(key);
    }

    //获得指定的存活的session
    @Override
    public Collection<Session> getActiveSessions() {
        //先获得redis所有的key值:根据前缀获得所有的key
        Set<byte[]> keys = jedisUtil.keys(SHIRO_SESSION_PREFIX);
        //
        Set<Session> sessions = new HashSet<>();
        if (CollectionUtils.isEmpty(keys)) {
            return sessions;
        }
        for (byte[] key : keys) {
            Session session = (Session) SerializationUtils.deserialize(jedisUtil.get(key));
            sessions.add(session);
        }
        return sessions;
    }
}
