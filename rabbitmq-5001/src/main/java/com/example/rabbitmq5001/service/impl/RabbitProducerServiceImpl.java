package com.example.rabbitmq5001.service.impl;

import com.example.rabbitmq5001.service.IRabbitProducerService;
import com.example.rabbitmq5001.utils.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/11
 */
@Service
public class RabbitProducerServiceImpl implements IRabbitProducerService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(Constants.QUEUE, message);
    }

    @Override
    public void producerDirect1(String message) {
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_DIRECT, Constants.ROUTING_KEY_DIRECT_1, message);
    }

    @Override
    public void producerDirect2(String message) {
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_DIRECT, Constants.ROUTING_KEY_DIRECT_2, message);
    }

    @Override
    public void producerFanout(String message) {
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_FANOUT, null, message);
    }

    @Override
    public void producerTopic(String message) {
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_TOPIC, Constants.ROUTING_KEY_TOPIC, message);
    }

    @Override
    public void producerHeaders(String message) {

    }
}
