package com.training.ykb.spring.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.training.ykb.spring.Order;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        Order orderLoc = new Order();
        orderLoc.setAmount(100);
        orderLoc.setContent(null);
        orderLoc.setCustomerId(10101);
        return Health.down()
                     .withDetail("info",
                                 orderLoc)
                     .build();
    }

}
