package com.example.redis.rookie;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {


    @Before
    public void before() {

        System.out.println("**************************************************************");

    }

    @After
    public void after() {

        System.out.println("**************************************************************");

    }

    @Autowired
    Base base;

    /**
     * Failed connecting to host localhost:6379
     * <p>
     * 出现这个异常就请先启动本地redis
     * <p>
     * docker-compose up
     */
    @Test
    public void first() {
        base.first();
    }

    /**
     * 字符串
     */
    @Test
    public void String() {
        base.String();
    }

    /**
     * 列表
     */
    @Test
    public void list() {
        base.list();
    }


    /**
     * 这个方法会获取redis所有的key
     */
    @Test
    public void keys() {
        base.keys();
    }


}