package com.cc.message;

import com.cc.core.AmqpConfig;
import com.cc.core.config.MessageQueueConfig;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by Chengcheng on 2017/5/25.
 */
@Component
public class Listener {

    private static Logger logger = Logger.getLogger(Listener.class);


    @RabbitListener(queues = "foo")
    @RabbitHandler
    public void onLoginMessage(Message message) {
        //String jsonString = new String(message.getBody());
        System.out.print("hellow world");
    }
}
