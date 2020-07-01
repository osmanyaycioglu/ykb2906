package com.training.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.ykb.spring",
//                                            "x.y.z"
//})
@EnableEurekaClient
public class MsCustomerAccountApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsCustomerAccountApplication.class,
                              args);
    }

}
