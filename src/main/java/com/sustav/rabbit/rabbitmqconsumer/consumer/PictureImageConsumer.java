package com.sustav.rabbit.rabbitmqconsumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sustav.rabbit.rabbitmqconsumer.entity.Employee;
import com.sustav.rabbit.rabbitmqconsumer.entity.ImageType;
import com.sustav.rabbit.rabbitmqconsumer.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PictureImageConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger logger = LoggerFactory.getLogger(PictureImageConsumer.class);
    private final static Map<String, ImageType> imageQueue = new HashMap<String, ImageType>() {
        {
            put("jpg", ImageType.JPG);
            put("png", ImageType.PNG);
            put("svg", ImageType.SVG);
        }

    };

    @RabbitListener(queues = {"q.picture.image", "q.picture.vector"})
    public void listener(String message) {

        Picture picture = null;
        try {
            picture = objectMapper.readValue(message, Picture.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("q.picture.{} => {}", ImageType.valueOf(picture == null ? "" : picture.getType().toUpperCase()), picture);
//        System.out.println(employee);
    }
}
