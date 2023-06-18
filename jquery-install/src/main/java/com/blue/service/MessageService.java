package com.blue.service;

import com.blue.dao.MessageDao;
import com.blue.entity.BookExample;
import com.blue.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Autowired
    private MessageDao messageDao;

    public List<Message> messageList(){
        return messageDao.messageList();
    }

    public List<BookExample> bookExampleList(int pageSize, int page){
        return BiologyBeanPoUtils.getBiologyBeanPoUtils().bookExampleList(pageSize,page);
    }

    public int getTotal(){
        return BiologyBeanPoUtils.getBiologyBeanPoUtils().examples.size();
    }
}
