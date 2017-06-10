package com.cc.core.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Chengcheng on 2017/6/10.
 */
@Component
public class MessageQueueConfig {

    /**
     * 测试rabbitmq key
     */
    public static final String FOO_EXCHANGE   = "exchange.foo";
    public static final String FOO_ROUTINGKEY = "routingkey.foo";
    public static final String FOO_QUEUE      = "foo";


}
