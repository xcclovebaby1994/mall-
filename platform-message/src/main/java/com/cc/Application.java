package com.cc;

import com.cc.message.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Chengcheng on 2017/5/25.
 */
@RestController
@SpringBootApplication
public class Application {

    @Autowired
    private Sender sender;

    @RequestMapping("/send")
    public String send(HttpServletRequest request,String msg) {
        sender.send(msg);
        return "Send OK.";
    }

    public static void main(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }

}
