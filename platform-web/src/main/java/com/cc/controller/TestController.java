package com.cc.controller;

import com.cc.message.MessageQueueSender;
import com.cc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Chengcheng on 2017/6/10.
 */
@RestController
public class TestController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private MessageQueueSender messageQueueSender;

    @RequestMapping("/")
    String home() {
//        redisTemplate.opsForValue().set("key","value");
        return "Hello World!";
    }

    @RequestMapping("/now")
    String hehe() {
        return "现在时间：" + (new Date()).toLocaleString();
    }

    @RequestMapping("/demo")
    String demo(){
//        int count = demoService.getCount();
//        Object key = redisTemplate.opsForValue().get("key");
        messageQueueSender.testMessage();
//        return "连接数据库成功" + count + "" + "redis = " + (String)key;
        return "发送消息成功";
    }
}
