package com.training.ykb.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "kitchen")
@RequestMapping("/kitchen")
public interface IKitchenClient {

    @PostMapping("/start/cooking")
    public KitchenResponse startCook(final Order orderParam) throws MyValidationException;

}
