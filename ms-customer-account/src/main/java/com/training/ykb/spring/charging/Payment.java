package com.training.ykb.spring.charging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ykb.spring.customer.Customer;
import com.training.ykb.spring.customer.CustomerManager;
import com.training.ykb.spring.order.Order;

@Service
public class Payment {

    @Autowired
    private CustomerManager customerManager;

    @Autowired
    private ChargingManager chargingManager;

    public boolean pay(final Order orderParam) {
        Customer customerLoc = this.customerManager.getCustomer(orderParam.getCustomerId());
        return this.chargingManager.charge(customerLoc,
                                           orderParam);
    }

}
