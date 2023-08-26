package com.ng.my.routing;

import com.my.common.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 生产者
 *
 * @author : chengdu
 * @date :  2023/8/20-08
 **/
public class EmitLogDirect {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String EXCHANGE_NAME = "logDirect";


    @Test
    public void acceptProducer() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        //创建交换机 并指定直接交换模式
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        //从控制台当中接受信息
        logger.info("start");

        //创建需要绑定的路由key  注意这里不说bingKey 是 routingKey
        Map<String, String> bindingKeyMap = new HashMap<>(4);
        bindingKeyMap.put("info", "普通 info 信息");
        bindingKeyMap.put("warning", "警告 warning 信息");
        bindingKeyMap.put("error", "错误 error 信息");
        //debug 没有消费这接收这个消息 所有就丢失了
        bindingKeyMap.put("debug", "调试 debug 信息");
        TimeUnit.SECONDS.sleep(10);
        Iterator<Map.Entry<String, String>> iterator = bindingKeyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> stringEntry = iterator.next();
            //路由key
            String routingKey = stringEntry.getKey();
            String message = stringEntry.getValue();
            logger.info("生产者 路由匹配算法key:" + routingKey);
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
        }

        TimeUnit.MINUTES.sleep(2);
        logger.info("end");
    }

}
