package com.training.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name = "customer", configuration = RibbonConfig.class)
public class MsOrderApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}
