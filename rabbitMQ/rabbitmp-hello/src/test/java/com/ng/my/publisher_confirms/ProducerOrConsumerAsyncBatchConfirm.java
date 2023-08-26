package com.ng.my.publisher_confirms;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;

public class ProducerOrConsumerAsyncBatchConfirm {

    public static int MESSAGE_COUNT = 5009;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static String QUEUE_NAME = "70daca38-6a27-491a-9b23-a43f5e601ad3";


    /**
     * 消费 MESSAGE_COUNT 个
     *
     * @throws Exception
     */
    @Test
    public void consumerWork() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        int prefetchCount = 10;
        //只处理一个
        channel.basicQos(prefetchCount);


        logger.info(DateUtil.now() + "等待接收消息....");

        //3:推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            logger.info("接收时间:" + DateUtil.now());
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
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }

    /**
     * 批量确认
     *
     * @throws Exception
     */
    @Test
    public void batchConfirm() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        logger.info("queue:" + queueName);
        channel.queueDeclare(queueName, true, false, true, null);

        //开启发布确认
        channel.confirmSelect();
        /**
         * 线程安全有序的一个哈希表，适用于高并发的情况
         * 1.轻松的将序号与消息进行关联
         * 2.轻松批量删除条目 只要给到序列号
         * 3.支持并发访问
         */
        ConcurrentSkipListMap<Long, String> outstandingConfirms = new ConcurrentSkipListMap<>();
        /**
         * 确认收到消息的一个回调
         * 1.消息序列号
         * 2.true 可以确认小于等于当前序列号的消息
         * false 确认当前序列号消息
         */
        ConfirmCallback ackCallback = (sequenceNumber, multiple) -> {
            if (multiple) {
                //返回的是小于等于当前序列号的未确认消息 是一个 map
                ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirms.headMap(sequenceNumber, true);
                //清除该部分未确认消息
                confirmed.clear();
            } else {
                //只清除当前序列号的消息
                outstandingConfirms.remove(sequenceNumber);
            }
        };
        ConfirmCallback nackCallback = (sequenceNumber, multiple) -> {
            String message = outstandingConfirms.get(sequenceNumber);
            System.out.println("发布的消息" + message + "未被确认，序列号" + sequenceNumber);
        };
        /**
         * 添加一个异步确认的监听器
         * 1.确认收到消息的回调
         * 2.未收到消息的回调
         */
        channel.addConfirmListener(ackCallback, nackCallback);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = String.format("%d-%s", RandomUtil.randomInt(90000), RandomUtil.randomString(20));
            /**
             * channel.getNextPublishSeqNo()获取下一个消息的序列号
             * 通过序列号与消息体进行一个关联
             * 全部都是未确认的消息体
             */
            outstandingConfirms.put(channel.getNextPublishSeqNo(), message);
            channel.basicPublish("", queueName, null, message.getBytes());
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个异步确认消息,耗时" + (end - begin) + "ms");
    }


}
