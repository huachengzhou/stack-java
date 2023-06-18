package com.gold.tree.redis;


import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoA {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testA() {
        /*
        * redisTemplate.opsForValue();//操作字符串
        * redisTemplate.opsForHash();//操作hash
        * redisTemplate.opsForList();//操作list
        * redisTemplate.opsForSet();//操作set
        * redisTemplate.opsForZSet();//操作有序set
        *
        * */
        stringRedisTemplate.opsForValue().append(RandomStringUtils.randomAlphanumeric(5),RandomStringUtils.randomNumeric(12)) ;

        stringRedisTemplate.opsForHash().put(RandomStringUtils.randomAlphanumeric(7,9), UUID.randomUUID().toString(),RandomStringUtils.randomNumeric(15));

        stringRedisTemplate.opsForSet().add(UUID.randomUUID().toString(),RandomStringUtils.randomNumeric(25),RandomStringUtils.randomNumeric(25)) ;

        stringRedisTemplate.opsForZSet().add(UUID.randomUUID().toString(),RandomStringUtils.randomNumeric(25),100) ;//分数相当于排序数值

        stringRedisTemplate.opsForList().leftPush((UUID.randomUUID().toString()),String.valueOf(RandomUtils.nextInt(33)));
    }


}
