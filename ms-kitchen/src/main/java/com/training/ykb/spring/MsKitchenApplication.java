package com.training.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsKitchenApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsKitchenApplication.class,
                              args);
    }

}
