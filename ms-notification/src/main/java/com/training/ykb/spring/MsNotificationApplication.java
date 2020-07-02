package com.training.ykb.spring;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class MsNotificationApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsNotificationApplication.class,
                              args);
    }

}
