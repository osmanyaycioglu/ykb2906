package com.training.ykb.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitlistener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "notification_response_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(value = "notification_response_exc",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notification_response"))
    public void name(final String order) {
        System.out.println("Response message : " + order);
    }


}
