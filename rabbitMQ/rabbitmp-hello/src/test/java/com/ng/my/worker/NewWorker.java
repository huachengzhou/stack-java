package com.ng.my.worker;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class NewWorker {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String TASK_QUEUE_NAME = "task_queue";

    @Test
    public void twoWork()throws Exception{
        oneWork() ;
    }


    @Test
    public void oneWork() throws Exception{
        Channel channel = RabbitMqUtils.getChannel();

        int prefetchCount = 1;
        //只处理一个
        channel.basicQos(prefetchCount);


        logger.info(DateUtil.now() +"等待接收消息....");

        //3:推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            logger.info("接收时间:"+DateUtil.now());
            //consumerTag 消费者标签，用来区分多个消费者
            logger.info("consumerTag:" + consumerTag);
            logger.info("properties:" + JSONUtil.toJsonStr(message.getProperties()));
            logger.info("envelope:" + JSONUtil.toJsonStr(message.getEnvelope()));
            logger.info("message:" + new String(message.getBody()));
            logger.info("");
        };
        //4:取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = consumerTag -> {
            //consumerTag 消费者标签，用来区分多个消费者
            logger.info("consumerTag:" + consumerTag);
        };

        /**
         * 消费者消费消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
         * 3.消费者未成功消费的回调
         */
        channel.basicConsume(TASK_QUEUE_NAME,true,deliverCallback,cancelCallback) ;
        TimeUnit.MINUTES.sleep(2);
    }

}
