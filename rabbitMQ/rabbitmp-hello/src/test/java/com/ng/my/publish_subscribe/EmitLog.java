package com.ng.my.publish_subscribe;

import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author : chengdu
 * @date :  2023/8/20-08
 **/
public class EmitLog {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String EXCHANGE_NAME = "logs";

    @Test
    public void acceptProducer()throws Exception{
        Channel channel = RabbitMqUtils.getChannel();

        //创建交换机 并指定广播模式
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        //从控制台当中接受信息
        logger.info("start");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.next();
            logger.info(" [x] Sent '" + message + "'");
            //将消息推入到广播模式的交换机中
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }

        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }

}
