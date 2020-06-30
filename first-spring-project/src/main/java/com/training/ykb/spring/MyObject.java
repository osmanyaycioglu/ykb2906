package com.training.ykb.spring;

import org.springframework.stereotype.Component;

@Component
public class MyObject {

    private String name;


    public String getName() {
        return this.name;
    }


    public void setName(final String nameParam) {
        this.name = nameParam;
    }

}
