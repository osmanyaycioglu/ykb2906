package com.training.ykb.spring;

import java.util.List;

public class Order {

    private long         customerId;
    private int          amount;
    private List<String> content;

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final long customerIdParam) {
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

    @Override
    public String toString() {
        return "Order [customerId=" + this.customerId + ", amount=" + this.amount + ", content=" + this.content + "]";
    }


}
