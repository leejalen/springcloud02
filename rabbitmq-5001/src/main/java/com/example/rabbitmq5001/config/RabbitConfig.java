package com.example.rabbitmq5001.config;

import com.example.rabbitmq5001.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/11
 */
@Slf4j
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue(Constants.QUEUE, true);
    }

    /**
     * 生产者的消息确认机制
     * */
    /*@Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //无论消息推送结果如何，强制调用回调函数
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("【消息确认机制ConfirmCallback 1】 相关数据：{}", correlationData);
                log.info("【消息确认机制ConfirmCallback 2】 确认情况：{}", ack);
                log.info("【消息确认机制ConfirmCallback 3】 失败原因：{}", cause);
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyMsg, String exchange, String routingKey) {
                log.info("【消息确认机制ReturnCallback 1】 原始消息：{}", message);
                log.info("【消息确认机制ReturnCallback 2】 回应码：{}", replyCode);
                log.info("【消息确认机制ReturnCallback 3】 回应信息：{}", replyMsg);
                log.info("【消息确认机制ReturnCallback 4】 交换机：{}", exchange);
                log.info("【消息确认机制ReturnCallback 5】 路由键：{}", routingKey);
            }
        });
        return rabbitTemplate;
    }*/
}
