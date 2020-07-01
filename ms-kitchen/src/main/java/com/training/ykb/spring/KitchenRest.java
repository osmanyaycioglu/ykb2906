package com.training.ykb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kitchen")
public class KitchenRest {

    @Autowired
    private KitchenManager km;

    @PostMapping("/start/cooking")
    public KitchenResponse startCook(final Order orderParam) {
        return this.km.startCooking(orderParam);
    }

}
