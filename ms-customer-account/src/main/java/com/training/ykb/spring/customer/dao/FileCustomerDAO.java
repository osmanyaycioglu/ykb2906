package com.training.ykb.spring.customer.dao;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.google.common.io.Files;
import com.training.ykb.spring.customer.Customer;

public class FileCustomerDAO implements ICustomerDAO {

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerListLoc = new ArrayList<>();
        try {
            List<String> readLinesLoc = Files.readLines(new File("customer.txt"),
                                                        Charset.defaultCharset());
            for (String stringLoc : readLinesLoc) {
                String[] splitLoc = stringLoc.split(",");
                Customer customerLoc = new Customer(Long.parseLong(splitLoc[0]),
                                                    splitLoc[1],
                                                    splitLoc[2],
                                                    splitLoc[3]);
                customerListLoc.add(customerLoc);
            }
        } catch (Exception eLoc) {
        }
        return customerListLoc;
    }
}
