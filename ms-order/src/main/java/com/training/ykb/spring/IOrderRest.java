package com.training.ykb.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "customer")
@RequestMapping("/order")
public interface IOrderRest {

    @PostMapping("/pay")
    public String pay(@RequestBody final Order orderParam);
}
