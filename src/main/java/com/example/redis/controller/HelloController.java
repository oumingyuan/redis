package com.example.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("ALL")
@RestController
public class HelloController {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Redis 字符串(String)
     * Redis 字符串数据类型的相关命令用于管理 redis 字符串值
     *
     * @param value 值
     */
    @RequestMapping("/set")
    public Map<String, String> set(String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        redisTemplate.opsForValue().set(key, value);
        return map;
    }


    @RequestMapping("/get")
    public Object get(String key) {

        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        return stringObjectValueOperations.get(key);
    }

    /**
     * Redis 哈希(Hash)
     * Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。
     *
     * @param key
     * @param valueMap
     */
    @RequestMapping("/setMap")
    public void setMap(String key, @RequestBody Map<String, String> valueMap) {
        System.out.println(key);
        System.out.println(valueMap);
        redisTemplate.opsForHash().putAll(key, valueMap);
    }

    @RequestMapping("/getMap")
    public Map<Object, Object> getMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * @param key
     * @param stringSet
     * @return
     */
    @RequestMapping("/setSet")
    public Set<String> setSet(String key, @RequestBody Set<String> stringSet) {
        redisTemplate.opsForSet().add(key, stringSet);
        return stringSet;
    }

    @RequestMapping("/getSet")
    public Set<Object> getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

}
