package com.gold.tree.redis;


import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoB {

    @Autowired
    private RedisTemplate redisTemplate; //在MyRedisConfig文件中配置了redisTemplate的序列化之后， 客户端也能正确显示键值对了

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
        redisTemplate.opsForValue().append(RandomStringUtils.randomAlphanumeric(5),RandomStringUtils.randomNumeric(12)) ;

        redisTemplate.opsForHash().put(RandomStringUtils.randomAlphanumeric(7,9), UUID.randomUUID().toString(),RandomStringUtils.randomNumeric(15));

        redisTemplate.opsForSet().add(UUID.randomUUID().toString(),RandomStringUtils.randomNumeric(25),RandomStringUtils.randomNumeric(25)) ;

        redisTemplate.opsForZSet().add(UUID.randomUUID().toString(),RandomStringUtils.randomNumeric(25),100) ;//分数相当于排序数值

        redisTemplate.opsForList().leftPush((UUID.randomUUID().toString()),String.valueOf(RandomUtils.nextInt(33)));
    }


}
