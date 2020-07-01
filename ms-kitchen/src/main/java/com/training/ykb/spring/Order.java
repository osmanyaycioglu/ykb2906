package com.training.ykb.spring;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Order {

    @NotNull(message = "customer id can not be null")
    @Positive(message = "wrong customer id")
    private Long         customerId;
    private int          amount;
    @Size(min = 1, message = "at least one content should be entered")
    private List<String> content;

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Long customerIdParam) {
        this.customerId = customerIdParam;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(final int amountParam) {
        this.amount = amountParam;
    }

    public List<String> getContent() {
        return this.content;
    }

    public void setContent(final List<String> contentParam) {
        this.content = contentParam;
    }


}
