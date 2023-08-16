package com.ng.my.hello_world;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : chengdu
 * @date :  2023/8/13-08
 **/
public class Producer {
    private final static String QUEUE_NAME = "hello";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 简单生产者
     * @throws Exception
     */
    @Test
    public void acceptProducer()throws Exception{
        //1:创建连接池
        ConnectionFactory connectionFactory = new ConnectionFactory() ;
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();
        //2:创建通道(数据交换通道)
        //channel 实现了自动 close 接口 自动关闭 不需要显示关闭
        Channel channel = connection.createChannel();

        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化 默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null) ;
        String message = "hello world "+ RandomUtil.randomInt(10,10000);
        /**
         * 发送一个消息
         * 1.发送到那个交换机
         * 2.路由的 key 是哪个
         * 3.其他的参数信息
         * 4.发送消息的消息体
         */
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes("UTF-8"));
        logger.info("message:"+message);
        logger.info(DateUtil.now() +"发送消息!");
    }

}
