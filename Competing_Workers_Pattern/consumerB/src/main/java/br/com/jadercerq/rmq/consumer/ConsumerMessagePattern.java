/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jadercerq.rmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 *
 * @author jader
 */
@Component
@Slf4j
public class ConsumerMessagePattern {
    @RabbitListener(queues = {"${queue.order.name}"})
    public void receive(@Payload String order) {
        log.info("Order: " + order);
    }
}
