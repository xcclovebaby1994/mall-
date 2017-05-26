package com.cc.config;

import org.apache.log4j.Logger;
import org.aspectj.weaver.ast.Test;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * Created by Chengcheng on 2017/5/25.
 */
@Configuration
@RabbitListener(queues = "foo")
public class Listener {

    private static Logger logger = Logger.getLogger(Listener.class);

    /** 设置交换机类型  */
    @Bean
    public DirectExchange defaultExchange() {
        /**
         * DirectExchange:按照routingkey分发到指定队列
         * TopicExchange:多关键字匹配
         * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
         * HeadersExchange ：通过添加属性key-value匹配
         */
        return new DirectExchange(AmqpConfig.FOO_EXCHANGE);
    }


    @Bean
    public Queue fooQueue() {
        return new Queue(AmqpConfig.FOO_QUEUE);
    }

    @Bean
    public Binding binding() {
        /** 将队列绑定到交换机 */
        return BindingBuilder.bind(fooQueue()).to(defaultExchange()).with(AmqpConfig.FOO_ROUTINGKEY);
    }

    @RabbitHandler
    public void process(@Payload String foo) {
        logger.info("Listener: " + foo);
    }
}
