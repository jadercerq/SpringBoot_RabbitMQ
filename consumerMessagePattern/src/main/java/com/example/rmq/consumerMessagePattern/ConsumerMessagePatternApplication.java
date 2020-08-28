package com.example.rmq.consumerMessagePattern;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ConsumerMessagePatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMessagePatternApplication.class, args);
    }

}
