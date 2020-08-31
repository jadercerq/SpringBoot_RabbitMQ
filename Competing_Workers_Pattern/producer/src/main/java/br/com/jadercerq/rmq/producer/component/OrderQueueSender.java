package br.com.jadercerq.rmq.producer.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String routingKey, String parkType) {
        rabbitTemplate.convertAndSend("amqp.direct", routingKey, parkType);
    }
}
