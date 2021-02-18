package com.example.rabbitmq5001.config.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author leejalen
 * Created on 2021/2/5
 * @Description
 */
@Slf4j
@Component
public class MyAckReceiver implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        log.info("消费者的监听信息：{}", message);
        log.info("消费者的监听信息：{}", message.toString());
    }
}
