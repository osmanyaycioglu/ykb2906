package com.training.ykb.spring.customer.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.training.ykb.spring.customer.CustomerManager;
import com.training.ykb.spring.customer.dao.FileCustomerDAO;
import com.training.ykb.spring.customer.dao.ICustomerDAO;
import com.training.ykb.spring.customer.dao.RandomCustomerDAO;

import x.y.z.MyConfig;

@Configuration
@Import(MyConfig.class)
public class CustomerAppConfig {


    @Value("${customer.dao.impl}")
    private int implChooser;


    @Bean
    // @Scope("prototype")
    public ICustomerDAO genCustDAO() {
        switch (this.implChooser) {
            case 1:
                return new RandomCustomerDAO();
            case 2:
                return new FileCustomerDAO();

            default:
                return new RandomCustomerDAO();
        }

    }

    @Bean
    // @Scope("prototype")
    @Qualifier("osman")
    public ICustomerDAO ranCustDAO() {
        return new RandomCustomerDAO();
    }

    @Bean
    // @Primary
    public ICustomerDAO fileCustDAO() {
        return new FileCustomerDAO();
    }

    @Bean
    public CustomerManager customerManager(@Qualifier("osman") final ICustomerDAO customerDAOParam) {
        return new CustomerManager(customerDAOParam);
    }


}
