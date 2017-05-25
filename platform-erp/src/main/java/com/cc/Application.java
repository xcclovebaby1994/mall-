package com.cc;

import com.cc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/now")
    String hehe() {
        return "现在时间：" + (new Date()).toLocaleString();
    }

    @RequestMapping("/demo")
    String demo(){
        int count = demoService.getCount();
        return "连接数据库成功" + count + "";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
