package com.example.rabbitmq5001.service;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/11
 */
public interface IRabbitConsumerService {

    /**
     * 消息消费者
     * */
    void consumerMessage(String message);

    /*直连消费者---------------------------------------------------------------------------------------*/

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

    /*扇形消费者---------------------------------------------------------------------------------------*/

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

    /*主题消费者---------------------------------------------------------------------------------------*/

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

    /**G
     * 主题交换机消费者
     * @param message 消费者获得的消息
     * */
    void consumerTopicG(String message);

}
