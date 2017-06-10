package com.cc.message.impl;

import com.cc.core.config.MessageQueueConfig;
import com.cc.message.MessageQueueSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Chengcheng on 2017/6/10.
 */
@Service
public class MessageQueueSenderImpl implements MessageQueueSender {

    private Logger logger = LoggerFactory.getLogger(MessageQueueSenderImpl.class);

    @Autowired
    private RabbitTemplate template;

    @Override
    public void testMessage() {
        template.convertAndSend("foo","123");
    }
}
