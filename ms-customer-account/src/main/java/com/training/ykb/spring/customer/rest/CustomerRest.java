package com.training.ykb.spring.customer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.spring.customer.Customer;
import com.training.ykb.spring.customer.CustomerManager;

@RestController
@RequestMapping("/customer")
public class CustomerRest {

    @Autowired
    private CustomerManager customerManager;

    @GetMapping("/getall")
    public List<Customer> getAll() {
        return this.customerManager.getAllCustomers();
    }

}
