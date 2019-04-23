package com.example.redis.controller;

import com.example.redis.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    private final RedisUtil redisUtil;

    public HelloController(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * 设置redis 的值
     *
     * @param value 值
     * @return 设置值是否成功
     */
    @RequestMapping("/set")
    public boolean set(String value) {

        System.out.println(value);

        return redisUtil.set(value, value);

    }

}
