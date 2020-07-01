package com.training.ykb.spring.charging;

import org.springframework.stereotype.Service;

import com.training.ykb.spring.customer.Customer;
import com.training.ykb.spring.order.Order;

@Service
public class ChargingManager {

    public boolean charge(final Customer customerParam,
                          final Order orderParam) {
        return true;
    }

}
