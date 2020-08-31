package br.com.jadercerq.rmq.producer.controller;

import br.com.jadercerq.rmq.producer.component.OrderQueueSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderQueueSender orderQueueSender;

    @PostMapping("/carros/{qtd}")
    public void sendCars(@RequestBody Integer qtd) {
        String parkCar = "Parking car";
        for (int i = 0; i < qtd; i++) {
            String jobs = parkCar.concat(" - ") + i;
            orderQueueSender.send("parking_carros", jobs);
        }
    }
    
    @PostMapping("/motos/{qtd}")
    public void sendBikes(@RequestBody Integer qtd) {
        String parkBike = "Parking bike";
        for (int i = 0; i < qtd; i++) {
            String jobs = parkBike.concat(" - ") + i;
            orderQueueSender.send("parking_motos", jobs);
        }
    }

}
