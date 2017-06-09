package com.cc;

import com.cc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Chengcheng on 2017/5/24.
 */
@RestController
@SpringBootApplication
public class Application {

    @Autowired
    private DemoService demoService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/")
    String home() {
        redisTemplate.opsForValue().set("key","value");
        return "Hello World!";
    }

    @RequestMapping("/now")
    String hehe() {
        return "现在时间：" + (new Date()).toLocaleString();
    }

    @RequestMapping("/demo")
    String demo(){
        int count = demoService.getCount();
        Object key = redisTemplate.opsForValue().get("key");

        return "连接数据库成功" + count + "" + "redis = " + (String)key;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }
}
