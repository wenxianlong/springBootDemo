package com.xkw.zujuan.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis 工具类
 *
 * @author wenxianlong
 * @date 2019-08-15
 */
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, String value, long expireTime){
         redisTemplate.opsForValue().set(key, value, expireTime);
    }
}
