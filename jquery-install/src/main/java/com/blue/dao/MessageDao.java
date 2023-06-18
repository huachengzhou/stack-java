package com.blue.dao;

import com.blue.entity.Message;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: zch
 * @Date: 2018/7/30 21:30
 * @Description:
 */
@Repository
public class MessageDao {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Message> messageList(){
        List<Message> messages = Lists.newArrayList();
        final int num = 12;
        for (int i = 0; i < num; i++) {
            Message message = new Message();
            message.setContent(RandomStringUtils.random(5)).
                    setCreate(new Date()).
                    setTitle(RandomStringUtils.random(6)).
                    setId(UUID.randomUUID().toString()).
                    setDescribe(String.valueOf(System.currentTimeMillis())).setGender(RandomUtils.nextInt(0,2));
            messages.add(message);
        }
        return messages;
    }
}
