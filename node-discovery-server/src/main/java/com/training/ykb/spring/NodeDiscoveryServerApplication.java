package com.training.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NodeDiscoveryServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(NodeDiscoveryServerApplication.class,
                              args);
    }

}
