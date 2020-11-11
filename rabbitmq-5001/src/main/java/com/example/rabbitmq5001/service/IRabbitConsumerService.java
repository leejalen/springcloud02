package com.example.rabbitmq5001.service;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/11
 */
public interface IRabbitConsumerService {

    /**
     * 直连交换机消费者A
     * @param message 消费者获得的消息
     * */
    void consumerDirectA(String message);

    /**
     * 直连交换机消费者B
     * @param message 消费者获得的消息
     * */
    void consumerDirectB(String message);

    /**
     * 扇形交换机消费者C
     * @param message 消费者获得的消息
     * */
    void consumerFanoutC(String message);

    /**
     * 扇形交换机消费者D
     * @param message 消费者获得的消息
     * */
    void consumerFanoutD(String message);

    /**
     * 主题交换机消费者E
     * @param message 消费者获得的消息
     * */
    void consumerTopicE(String message);

    /**
     * 主题交换机消费者F
     * @param message 消费者获得的消息
     * */
    void consumerTopicF(String message);
}
