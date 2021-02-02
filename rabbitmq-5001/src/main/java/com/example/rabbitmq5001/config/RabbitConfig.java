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

    @Bean
    public Queue queue(){
        return new Queue(Constants.QUEUE, true);
    }
}
