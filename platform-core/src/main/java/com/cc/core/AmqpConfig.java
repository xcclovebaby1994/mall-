package com.cc.core;

import com.cc.core.config.MessageQueueConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Chengcheng on 2017/5/26.
 */
@Configuration
public class AmqpConfig {

    @Bean
    public Queue queueFOO() {
        return new Queue(MessageQueueConfig.FOO_QUEUE, true); //队列持久
    }
    @Bean
    public FanoutExchange fooExchange(){
        return new FanoutExchange(MessageQueueConfig.FOO_EXCHANGE);
    }
    @Bean
    public Binding bindingFOO() {
        return BindingBuilder.bind(queueFOO()).to(fooExchange());
    }

}
