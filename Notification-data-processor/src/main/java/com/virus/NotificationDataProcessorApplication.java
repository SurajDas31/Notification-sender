package com.virus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotificationDataProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationDataProcessorApplication.class, args);
    }

}
