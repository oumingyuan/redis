package com.example.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@RestController
public class HelloController {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Redis 字符串(String)
     * 设置redis 的值
     *
     * @param value 值
     */
    @RequestMapping("/set")
    public Map<String, String> set(String key, String value) {
//        return redisUtil.set(key, value);

        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        redisTemplate.opsForValue().set(key, value);
        return map;


    }

    @RequestMapping("/setMap")
    public Map<String, Map<String, String>> setMap(String key, Map<String, String> valueMap) {
//        return redisUtil.set(key, value);

        Map<String, Map<String, String>> resultMap = new HashMap<>();
//        Map<String, String> VA
        resultMap.put(key, valueMap);
//        redisTemplate.opsForValue().set(key, value);
        redisTemplate.opsForHash().putAll(key, valueMap);
        return resultMap;


    }

    @RequestMapping("/get")
    public Object get(String key) {
//        System.out.println(value);
        return redisTemplate.opsForValue().get(key);
    }

}
