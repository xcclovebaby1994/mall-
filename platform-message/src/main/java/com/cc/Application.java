package com.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chengcheng on 2017/5/25.
 */
@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }

}
