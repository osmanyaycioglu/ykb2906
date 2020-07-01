package com.training.ykb.spring.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.spring.charging.Payment;
import com.training.ykb.spring.order.Order;

@RestController
@RequestMapping("/order")
public class OrderChargingRest {

    @Autowired
    private Payment payment;

    @Value("${server.port}")
    private int     port;

    @PostMapping("/pay")
    public String pay(@RequestBody final Order orderParam) {
        if (this.payment.pay(orderParam)) {
            return "OK " + this.port;
        } else {
            return "FAIL " + this.port;
        }
    }
}
