package com.training.ykb.spring.customer;


public class Customer {

    private long   customerId;
    private String name;
    private String surname;
    private String creditCard;


    public Customer() {
    }


    public Customer(final long customerIdParam,
                    final String nameParam,
                    final String surnameParam,
                    final String creditCardParam) {
        super();
        this.customerId = customerIdParam;
        this.name = nameParam;
        this.surname = surnameParam;
        this.creditCard = creditCardParam;
    }


    public long getCustomerId() {
        return this.customerId;
    }

    public Customer setCustomerId(final long customerIdParam) {
        this.customerId = customerIdParam;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Customer setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

    public String getSurname() {
        return this.surname;
    }

    public Customer setSurname(final String surnameParam) {
        this.surname = surnameParam;
        return this;
    }

    public String getCreditCard() {
        return this.creditCard;
    }

    public Customer setCreditCard(final String creditCardParam) {
        this.creditCard = creditCardParam;
        return this;
    }


}
