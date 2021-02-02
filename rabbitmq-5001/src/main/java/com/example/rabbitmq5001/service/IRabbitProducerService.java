package com.example.rabbitmq5001.service;

/**
 * @author leejalen
 * @Description
 * Created on 2020/11/11
 */
public interface IRabbitProducerService {

    /**
     * 发送消息
     * @param message 消息
     * */
    public void sendMessage(String message);

    /**
     * 直连交换机生产者
     * @param message 生产者发送的消息
     * */
    void producerDirect1(String message);

    /**
     * 直连交换机生产者
     * @param message 生产者发送的消息
     * */
    void producerDirect2(String message);

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
