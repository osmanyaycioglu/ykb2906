package com.training.ykb.spring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitlistener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "notification_q",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(value = "not_direct_exc",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "notification_key"))
    @SendTo("notification_response_exc/notification_response")
    public String abc(final Order order) {
        System.out.println("Gelen msg : " + order);
        return "notification success : " + order;
    }


}
