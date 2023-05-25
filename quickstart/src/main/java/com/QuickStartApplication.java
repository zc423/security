package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuickStartApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(QuickStartApplication.class, args);
        System.out.println("111");
    }
}
