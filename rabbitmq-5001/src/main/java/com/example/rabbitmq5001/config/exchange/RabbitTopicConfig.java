package com.example.rabbitmq5001.config.exchange;

import com.example.rabbitmq5001.utils.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * Created on 2021/2/2
 * @Description 主题模式
 */
@Configuration
public class RabbitTopicConfig {

    /*-------------------------------------队列---------------------------------------*/

    @Bean
    public Queue topicQueueE(){
        return new Queue(Constants.QUEUE_TOPIC_E);
    }

    @Bean
    public Queue topicQueueF(){
        return new Queue(Constants.QUEUE_TOPIC_F);
    }

    @Bean
    public Queue topicQueueG(){
        return new Queue(Constants.QUEUE_TOPIC_G);
    }

    /*-------------------------------------交换机---------------------------------------*/

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(Constants.EXCHANGE_TOPIC);
    }

    /*-------------------------------------绑定队列和主题交换机----------------------------*/

    @Bean
    public Binding bindingWithQueueE(){
        return BindingBuilder.bind(topicQueueE()).to(topicExchange()).with(Constants.ROUTING_KEY_TOPIC_1);
    }

    @Bean
    public Binding bindingWithQueueF(){
        return BindingBuilder.bind(topicQueueF()).to(topicExchange()).with(Constants.ROUTING_KEY_TOPIC_ONE);
    }

    @Bean
    public Binding bindingWithQueueG(){
        return BindingBuilder.bind(topicQueueG()).to(topicExchange()).with(Constants.ROUTING_KEY_TOPIC_ALL);
    }
}
