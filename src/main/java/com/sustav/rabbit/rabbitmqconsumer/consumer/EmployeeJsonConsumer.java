package com.sustav.rabbit.rabbitmqconsumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sustav.rabbit.rabbitmqconsumer.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeJsonConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger logger = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    @RabbitListener(queues = {"course.employee"})
    public void listener(String message) {

        Employee employee = null;
        try {
            employee = objectMapper.readValue(message, Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Rabbit fixed sent {}", employee);
//        System.out.println(employee);
    }
}
