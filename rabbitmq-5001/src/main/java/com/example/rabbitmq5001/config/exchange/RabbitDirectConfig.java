package com.example.rabbitmq5001.config.exchange;

import com.example.rabbitmq5001.utils.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2021/2/2
 * @Description 直连模式（直连交换机将消息路由到那些 binding key 与 routing key完全匹配的Queue中）
 */
@Configuration
public class RabbitDirectConfig {

    /*-------------------------------------队列---------------------------------------*/

    /**
     * 直连交换机，队列A
     * */
    @Bean
    public Queue directQueueA(){
        return new Queue(Constants.QUEUE_DIRECT_A);
    }

    /**
     * 直连交换机，队列B
     * */
    @Bean
    public Queue directQueueB(){
        return new Queue(Constants.QUEUE_DIRECT_B);
    }

    /*-------------------------------------直连交换机---------------------------------------*/

    /**
     * 设置直连交换机
     * */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(Constants.EXCHANGE_DIRECT);
    }

    /*-------------------------------------绑定队列和直连交换机-------------------------------*/

    /**
     * 队列A与直连交换机绑定在一起
     * */
    @Bean
    public Binding bindingWithQueueA() {
        return BindingBuilder.bind(directQueueA()).to(directExchange()).with(Constants.ROUTING_KEY_DIRECT_1);
    }

    /**
     * 队列B与直连交换机绑定在一起
     * */
    @Bean
    public Binding bindingWithQueueB() {
        return BindingBuilder.bind(directQueueB()).to(directExchange()).with(Constants.ROUTING_KEY_DIRECT_2);
    }
}
