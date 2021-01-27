package com.example.redis.rookie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCoreTest {


    @Autowired
    RedisCore redisCore;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Before
    public void setUp() {

        System.out.println("**************************************************************");
    }

    @After
    public void tearDown() {

        System.out.println("**************************************************************");
    }

    @Test
    public void expire() {
    }

    @Test
    public void getExpire() {
    }

    @Test
    public void hasKey() {

        System.out.println(redisCore.hasKey("cat"));

        System.out.println("has key");

        String cat = redisTemplate.opsForValue().get("hello");
        System.out.println(cat);
    }

    @Test
    public void set() {

        redisCore.set("hello", "world");

        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        redisCore.set("map", map);

        System.out.println("has key");
    }

    @Test
    public void hmset() {


        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        redisCore.hmset("map1", map);

        System.out.println("has key");
    }
}