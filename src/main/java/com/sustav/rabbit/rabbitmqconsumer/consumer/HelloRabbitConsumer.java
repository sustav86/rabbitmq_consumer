package com.sustav.rabbit.rabbitmqconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class HelloRabbitConsumer {

    @RabbitListener(queues = {"course.hello"})
    public void listener(String message) {
        System.out.println("Rabbit sent " + message);
    }
}
