package com.blue.service;

import com.blue.dao.MessageDao;
import com.blue.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zch
 * @Date: 2018/7/30 21:40
 * @Description:
 */
@Service
public class MessageService {


    @Autowired
    private MessageDao messageDao;

    public List<Message> messageList(){
        return messageDao.messageList();
    }
}
