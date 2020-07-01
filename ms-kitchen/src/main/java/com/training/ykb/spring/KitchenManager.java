package com.training.ykb.spring;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.stereotype.Service;

@Service
public class KitchenManager {

    private final Queue<Order> orders = new ArrayBlockingQueue<>(100);

    public boolean add(final Order order) {
        return this.orders.add(order);
    }

    public int queueSize() {
        return this.orders.size();
    }

    public KitchenResponse startCooking(final Order orderParam) {
        if (this.queueSize() > 20) {
            return KitchenResponse.fail("Çok fazla bekleyen var");
        }
        List<String> contentLoc = orderParam.getContent();
        StringBuilder builderLoc = new StringBuilder();
        for (String stringLoc : contentLoc) {
            builderLoc.append(stringLoc);
            builderLoc.append(",");
        }
        builderLoc.append(" hazırlanıyor");
        return KitchenResponse.success(builderLoc.toString(),
                                       ((this.orders.size() / 2) * 5) + (contentLoc.size() * 5));
    }
}
