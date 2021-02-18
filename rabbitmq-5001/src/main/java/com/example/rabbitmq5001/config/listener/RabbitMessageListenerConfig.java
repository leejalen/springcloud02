package com.example.rabbitmq5001.config.listener;

import com.example.rabbitmq5001.utils.Constants;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2021/2/5
 * @Description 消费者的消息确认机制配置
 */
@Configuration
public class RabbitMessageListenerConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private MyAckReceiver myAckReceiver;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(10);
        container.setMaxConcurrentConsumers(10);
        //消费者的消息确认机制改为手动
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        //设置队列
        container.setQueueNames(Constants.QUEUE_DIRECT_A);
        //方法一：设置多个队列
        //container.setQueueNames(Constants.QUEUE_DIRECT_A, Constants.QUEUE_DIRECT_B);

        //方法二：设置多个队列
        //container.setQueues(new Queue(Constants.QUEUE_DIRECT_A,true));
        //container.addQueues(new Queue(Constants.QUEUE_DIRECT_A,true));
        //container.addQueues(new Queue(Constants.QUEUE_DIRECT_A,true));

        container.setMessageListener(myAckReceiver);
        return container;
    }
}
