package com.example.rabbitmq5001.service.impl;

import com.example.rabbitmq5001.service.IRabbitConsumerService;
import com.example.rabbitmq5001.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * Created on 2020/11/11
 * @author leejalen
 */
@Service
public class RabbitConsumerServiceImpl implements IRabbitConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitConsumerServiceImpl.class);

    @Override
    @RabbitListener(queues = Constants.QUEUE)
    public void consumerMessage(String message) {
        logger.info("接收到消息队列中的消息：{}", message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_DIRECT_A)
    public void consumerDirectA(String message) {
        logger.info("消费者收到直连交换机的队列A中的消息：{}", message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_DIRECT_B)
    public void consumerDirectB(String message) {
        logger.info("消费者收到直连交换机的队列B中的消息：{}", message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_FANOUT_C)
    public void consumerFanoutC(String message) {
        logger.info("消费者收到扇形交换机的队列C中的消息：{}", message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_FANOUT_D)
    public void consumerFanoutD(String message) {
        logger.info("消费者收到扇形交换机的队列D中的消息：{}", message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_TOPIC_E)
    public void consumerTopicE(String message) {
        logger.info("消费者收到主题交换机的队列E中的消息：{}", message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_TOPIC_F)
    public void consumerTopicF(String message) {
        logger.info("消费者收到主题交换机的队列F中的消息：{}", message);
    }

    @Override
    @RabbitListener(queues = Constants.QUEUE_TOPIC_G)
    public void consumerTopicG(String message) {
        logger.info("消费者收到主题交换机的队列G中的消息：{}", message);
    }
}
