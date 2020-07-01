package com.training.ykb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
@EnableConfigServer
public class NodeConfigServerApplication {


    @Scheduled(fixedDelayString = "${my.method.period}")
    public void myMethod() {
        System.out.println("Hello wrold");
    }

    public static void main(final String[] args) {
        SpringApplication.run(NodeConfigServerApplication.class,
                              args);
    }

}
