package com.jiahao.per_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerDemoApplication.class, args);
    }

}
