package com.cc.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by Chengcheng on 2017/5/26.
 */
public class BaseRedisRepository {

    @Autowired
    protected RedisTemplate redisTemplate;

}
