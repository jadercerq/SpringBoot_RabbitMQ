package br.com.jadercerq.rmq.producer.controller;

import br.com.jadercerq.rmq.producer.component.OrderQueueSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderQueueSender orderQueueSender;
    
    @Autowired
    private Queue queueCar;
    
    @Autowired
    private Queue queueBike;

    @Qualifier("queueCar")
    @PostMapping("/carros/{qtd}")
    public void sendCars(@PathVariable Integer qtd) {
        String parkCar = "Parking car";
        for (int i = 0; i < qtd; i++) {
            String jobs = parkCar.concat(" - ") + i;
            orderQueueSender.send(queueCar.getName(), jobs);
        }
    }
    
    @Qualifier("queueBike")
    @PostMapping("/motos/{qtd}")
    public void sendBikes(@PathVariable Integer qtd) {
        String parkBike = "Parking bike";
        for (int i = 0; i < qtd; i++) {
            String jobs = parkBike.concat(" - ") + i;
            orderQueueSender.send(queueBike.getName(), jobs);
        }
    }

}
