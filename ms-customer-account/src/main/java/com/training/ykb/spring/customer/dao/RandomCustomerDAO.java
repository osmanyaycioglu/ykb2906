package com.training.ykb.spring.customer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.training.ykb.spring.customer.Customer;

public class RandomCustomerDAO implements ICustomerDAO {

    @Override
    public List<Customer> getAllCustomer() {
        Random randomLoc = new Random();
        int nextIntLoc = randomLoc.nextInt(10);
        List<Customer> customerListLoc = new ArrayList<>();
        for (int iLoc = 0; iLoc < (nextIntLoc + 1); iLoc++) {
            customerListLoc.add(new Customer().setCustomerId(iLoc)
                                              .setName("osman" + randomLoc.nextInt())
                                              .setSurname("" + randomLoc.nextInt())
                                              .setCreditCard("" + randomLoc.nextLong()));

        }
        return customerListLoc;
    }

}
