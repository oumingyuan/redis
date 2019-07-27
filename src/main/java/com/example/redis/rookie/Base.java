package com.example.redis.rookie;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

@Component
public class Base {

    void first() {
        // 程序代码
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        //查看服务是否运行
        System.out.println(String.format("服务正在运行: %s", jedis.ping()));
        System.out.println("连接成功");


    }


    /**
     * 字符串
     */
    void String() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        //设置 redis 字符串数据
        jedis.set("hello", "www.hello.com");
        // 获取存储的数据并输出
        System.out.println(String.format("redis 存储的字符串为: %s", jedis.get("hello")));
    }

    /**
     * 列表
     */
    void list() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0, 2);
        System.out.println(String.format("列表项为: %s", list));

    }


    /**
     * 获取redis所有的key
     */
    void keys() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");

        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        System.out.println(String.format("keys in redis: %s", keys));


    }
}
