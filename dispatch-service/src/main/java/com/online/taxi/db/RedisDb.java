package com.online.taxi.db;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * redis库
 *
 * @author dongjb
 * @date 2021/04/24
 */
@Repository
@RequiredArgsConstructor
public class RedisDb {

    @NonNull
    private final RedisTemplate<String, String> redisTemplate;

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, String value, long expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public boolean setnx(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public String getSet(String key, String value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    public boolean setnx(String key, String value, int second) {

        boolean b = redisTemplate.opsForValue().setIfAbsent(key, value);
        if (b) {
            redisTemplate.expire(key, second, TimeUnit.SECONDS);
        }
        return b;
    }
}
