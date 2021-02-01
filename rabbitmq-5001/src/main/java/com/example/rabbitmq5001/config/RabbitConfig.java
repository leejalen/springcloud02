package com.example.rabbitmq5001.config;

import com.example.rabbitmq5001.utils.Constants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/11
 */
@Configuration
public class RabbitConfig {

    //===========路由模式=============
    /**
     * 直连交换机，队列A
     * */
    @Bean
    public Queue directQueueA(){
        return new Queue(Constants.QUEUE_DIRECT_A, true);
    }

    /**
     * 直连交换机，队列B
     * */
    /*@Bean
    public Queue directQueueB(){
        return new Queue(Constants.QUEUE_DIRECT_B);
    }*/

    /**
     * 设置直连交换机
     * */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(Constants.EXCHANGE_DIRECT);
    }

    /**
     * 队列A与直连交换机绑定在一起
     * */
    @Bean
    public Binding bindingWithQueueA() {
        return BindingBuilder.bind(directQueueA()).to(directExchange()).with(Constants.ROUTING_KEY_DIRECT);
    }

    /**
     * 队列B与直连交换机绑定在一起
     * */
    /*@Bean
    public Binding bindingWithQueueB() {
        return BindingBuilder.bind(directQueueB()).to(directExchange()).with(Constants.ROUTING_KEY_DIRECT);
    }*/

    //===========发布/订阅模式=============
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

    /**
     * 设置扇形交换机
     * */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(Constants.EXCHANGE_FANOUT);
    }

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
