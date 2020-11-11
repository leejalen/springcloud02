package com.example.rabbitmq5001.service.impl;

import com.example.rabbitmq5001.service.IRabbitConsumerService;
import com.example.rabbitmq5001.utils.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * Created on 2020/11/11
 * @author leejalen
 */
@Component
public class RabbitConsumerServiceImpl implements IRabbitConsumerService {

    @Override
    @RabbitListener(queues = Constants.QUEUE_DIRECT_A)
    public void consumerDirectA(String message) {
        System.out.println("消费者收到队列A中的消息:" + message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_DIRECT_B)
    public void consumerDirectB(String message) {
        System.out.println("消费者收到队列B中的消息:" + message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_FANOUT_C)
    public void consumerFanoutC(String message) {
        System.out.println("消费者收到队列C中的消息:" + message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_FANOUT_D)
    public void consumerFanoutD(String message) {
        System.out.println("消费者收到队列D中的消息:" + message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_TOPIC_E)
    public void consumerTopicE(String message) {
        System.out.println("消费者收到队列E中的消息:" + message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_TOPIC_F)
    public void consumerTopicF(String message) {
        System.out.println("消费者收到队列F中的消息:" + message);
    }
}
