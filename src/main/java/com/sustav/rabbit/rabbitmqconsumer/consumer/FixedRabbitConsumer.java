package com.sustav.rabbit.rabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class FixedRabbitConsumer {

    private Logger logger = LoggerFactory.getLogger(FixedRabbitConsumer.class);

    @RabbitListener(queues = {"course.fixedrate"}, concurrency = "3")
    public void listener(String message) {
        logger.info("Rabbit fixed sent {}, in thread {}", message, Thread.currentThread().getName());
    }
}
