package com.training.ykb.spring.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.ykb.spring.customer.dao.ICustomerDAO;

public class CustomerManager {

    private final ICustomerDAO        customerDoa;

    private final Map<Long, Customer> customerMap = new ConcurrentHashMap<>(5000,
                                                                            0.9f,
                                                                            50);

    @Autowired
    public CustomerManager(final ICustomerDAO customerDoa) {
        this.customerDoa = customerDoa;
        List<Customer> customers = this.customerDoa.getAllCustomer();
        for (Customer customerLoc : customers) {
            this.customerMap.put(customerLoc.getCustomerId(),
                                 customerLoc);
        }
    }

    @PostConstruct
    public void init() {
    }

    // Method wiring
    // @Autowired
    public void xyz(final ICustomerDAO customerDoa) {

    }

    public Customer getCustomer(final long customerIdParam) {
        return this.customerMap.get(customerIdParam);

    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(this.customerMap.values());
    }

}
