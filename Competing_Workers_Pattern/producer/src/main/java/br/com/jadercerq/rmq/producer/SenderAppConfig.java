package br.com.jadercerq.rmq.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SenderAppConfig {

    @Value("${routing.order.car}")
    private String orderQueueCar;
    
    @Value("${routing.order.bike}")
    private String orderQueueBike;

    public static void main(String[] args) {
        SpringApplication.run(SenderAppConfig.class, args);
    }

    @Bean
    public Queue queueCar() {
        return new Queue(orderQueueCar, true);
    }
    
    @Bean
    public Queue queueBike() {
        return new Queue(orderQueueBike, true);
    }
}