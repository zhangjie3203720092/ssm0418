package com.zking.ssm.redis;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {

    private static final Logger LOG = LoggerFactory.getLogger(RedisCache.class);

    private final String id;

    /**
     * The {@code ReadWriteLock}.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 使用中间类RedisCacheTransfer(此类配置在spring-redis.xml中)解决RedisTemplate的静态注入，从而使MyBatis实现第三方缓存
     */
    private static RedisTemplate<String, Object> redisTemplate;

    private JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();

    // private static RedisSerializer valueSerializer;

    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }

        LOG.debug("RedisCache:id=" + id);
        this.id = id;
    }

    public static void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisCache.redisTemplate = redisTemplate;
        //valueSerializer = RedisCache.redisTemplate.getValueSerializer();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (value != null) {
            LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>putObject:");
            LOG.info("[" + key + "]");
            //redisTemplate.opsForValue().set(key.toString(), jdkSerializer.serialize(value), 2, TimeUnit.DAYS);
            //byte[] bytes = valueSerializer.serialize(value);
            //redisTemplate.opsForValue().set(key.toString(), bytes, 2, TimeUnit.DAYS);

            redisTemplate.opsForValue().set(key.toString(), value, 2, TimeUnit.DAYS);
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>getObject:");
            LOG.info("[" + key + "]");
            if (key != null) {
                return redisTemplate.opsForValue().get(key.toString());
            }
        } catch (Exception e) {
            // LOG.error(e.toString());
            e.printStackTrace();
            LOG.error("redis ");
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        try {
            if (key != null) {
                redisTemplate.expire(key.toString(), 1, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void clear() {
        Long size = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                Long size = connection.dbSize();
                connection.flushDb();//连接清除数据
                connection.flushAll();
                return size;
            }
        });
        LOG.info(">>>>>>>>>>>>>>>>>>>>>>>>clear: 清除了" + size + "个对象");
    }

    @Override
    public int getSize() {
        Long size = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.dbSize();
            }
        });
        return size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
