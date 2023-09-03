package com.me.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MQConfig {


    public static final String BOOT_TOPIC_EXCHANGE = "boot-topic-exchange";
    public static final String BOOT_TOPIC_QUEUE = "boot-topic-queue";

    public static final String EXCHANGE_TTL_WAITING = "exchangeTTLWaiting";
    public static final String QUEUE_TTL_WAITING = "queueTTLWaiting";

    public static final String EXCHANGE_WAITING = "exchangeWaiting";
    public static final String QUEUE_WAITING = "queueWaiting";

    //1、创建exchange topic
    @Bean(value = BOOT_TOPIC_EXCHANGE)
    public TopicExchange getTopicExchage() {
        return new TopicExchange(BOOT_TOPIC_EXCHANGE, true, false);
    }

    //2、创建queue
    @Bean(value = BOOT_TOPIC_QUEUE)
    public Queue getQueue() {
        return new Queue(BOOT_TOPIC_QUEUE, true, false, false, null);
    }


    //3、绑定
    @Bean(value = "default_binding")
    public Binding getBinding(@Qualifier(value = BOOT_TOPIC_EXCHANGE) TopicExchange topicExchange, @Qualifier(value = BOOT_TOPIC_QUEUE) Queue queue) {
        return BindingBuilder.bind(queue).to(topicExchange).with("ERROR");
    }

    //ttl start

    /**
     * TTL交换机
     */
    @Bean(value = EXCHANGE_TTL_WAITING)
    public Exchange exchangeTTLWaiting() {
        DirectExchange exchange = new DirectExchange(EXCHANGE_TTL_WAITING, false, false);
        return exchange;
    }

    /**
     * TTL队列
     */
    @Bean(value = QUEUE_TTL_WAITING)
    public Queue queueTTLWaiting() {
        Map<String, Object> props = new HashMap<>();
        //对于该队列中的消息，设置都等待10s
        props.put("x-message-ttl", 10000);
        Queue queue = new Queue(QUEUE_TTL_WAITING, false, false, false, props);
        return queue;
    }


    /**
     * TTL交换机和队列绑定
     */
    @Bean(value = "bindingTTLWaiting")
    public Binding bindingTTLWaiting() {
        return BindingBuilder.bind(queueTTLWaiting()).to(exchangeTTLWaiting()).with(QUEUE_TTL_WAITING).noargs();
    }

    //ttl end

    //延迟队列 start


    /**
     * 该交换器使用的时候，需要给每个消息设置有效期
     */
    @Bean(value = EXCHANGE_WAITING)
    public Exchange exchangeWaiting() {
        DirectExchange exchange = new DirectExchange(EXCHANGE_WAITING, false, false);
        return exchange;
    }


    @Bean(value = QUEUE_WAITING)
    public Queue queueWaiting() {
        Queue queue = new Queue(QUEUE_WAITING, false, false,
                false);
        return queue;
    }


    @Bean(value = "bindingWaiting")
    public Binding bindingWaiting() {
        return BindingBuilder.bind(queueWaiting()).to(exchangeWaiting()).with(QUEUE_WAITING).noargs();
    }

    //延迟队列 end

}

