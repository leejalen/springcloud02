package com.example.rabbitmq5001.service;

/**
 * @author leejalen
 * @Description
 * Created on 2020/11/11
 */
public interface IRabbitProducerService {

    /**
     * 直连交换机生产者
     * @param message 生产者发送的消息
     * */
    void producerDirect(String message);

    /**
     * 扇形交换机生产者
     * @param message 生产者发送的消息
     * */
    void producerFanout(String message);

    /**
     * 主题交换机生产者
     * @param message 生产者发送的消息
     * */
    void producerTopic(String message);

    /**
     * 头部交换机生产者
     * @param message 生产者发送的消息
     * */
    void producerHeaders(String message);
}
