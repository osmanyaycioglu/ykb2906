package com.training.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class FirstSpringProjectApplication {

    @Autowired
    private MyObject myObject;


    public static void main(final String[] args) {
        ConfigurableApplicationContext runLoc = SpringApplication.run(FirstSpringProjectApplication.class,
                                                                      args);
        FirstSpringProjectApplication beanLoc = runLoc.getBean(FirstSpringProjectApplication.class);
        beanLoc.myObject.getName();

    }

}
