package com.example.HelloWorld.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello")
public class Receiver {
    @RabbitHandler
    public void receive(String message){
        System.out.println(" [x] Received '" + message + "'");
    }
}
