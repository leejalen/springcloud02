package com.example.rabbitmq5001.config.exchange;

import com.example.rabbitmq5001.utils.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2021/2/2
 * @Description 扇形模式（扇形交换机将消息路由到所有与自己绑定的Queue中）
 * 广播是实时的，生产者只负责发出去，不管消费者是否收到。若发送的时刻没有消费者接收，那消息就没了，因此在广播模式下设置消息持久化是无效的。
 */
@Configuration
public class RabbitFanoutConfig {

    /*-------------------------------------队列---------------------------------------*/

    /**
     * 扇形交换机，队列C
     * */
    @Bean
    public Queue fanoutQueueC(){
        return new Queue(Constants.QUEUE_FANOUT_C);
    }

    /**
     * 扇形交换机，队列D
     * */
    @Bean
    public Queue fanoutQueueD(){
        return new Queue(Constants.QUEUE_FANOUT_D);
    }

    /*-------------------------------------交换机---------------------------------------*/

    /**
     * 设置扇形交换机
     * */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(Constants.EXCHANGE_FANOUT);
    }

    /*-------------------------------------绑定队列和扇形交换机-------------------------------*/

    /**
     * 队列C与扇形交换机绑定在一起
     * */
    @Bean
    public Binding bindingWithQueueC() {
        return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
    }

    /**
     * 队列D与扇形交换机绑定在一起
     * */
    @Bean
    public Binding bindingWithQueueD() {
        return BindingBuilder.bind(fanoutQueueD()).to(fanoutExchange());
    }
}
