package com.example.rabbitmq5001.controller;

import com.example.rabbitmq5001.service.IRabbitProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * Created on 2020/11/11
 * @author leejalen
 */
@Slf4j
@RestController
@RequestMapping("/producer")
public class RabbitProducerController {

    @Autowired
    private IRabbitProducerService rabbitProducerService;

    @PostMapping("/test")
    public String test(){
        return "success";
    }

    @PostMapping("/send")
    public void send() {
        for (int i = 0; i < 5; i++) {
            rabbitProducerService.sendMessage("我是生产者，这是我发送的第" + i + "条信息");
            log.info("已发送第{}条消息", i);
        }
    }

    @PostMapping("/send/direct")
    public void direct() {
        for (int i = 0; i < 5; i++) {
            rabbitProducerService.producerDirect1("我是生产者，这是直连模式下的第" + i + "条信息");
            log.info("已发送第{}条消息", i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            rabbitProducerService.producerDirect2("我是生产者，这是直连模式下的第" + i + "条信息");
            log.info("已发送第{}条消息", i);
        }
    }

    @PostMapping("/send/fanout")
    public void fanout() {
        for (int i = 0; i < 5; i++) {
            rabbitProducerService.producerFanout("我是生产者，这是扇形模式下的第" + i + "条信息");
            log.info("已发送第{}条消息", i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping("/send/topic")
    public void topic() {
        for (int i = 0; i < 5; i++) {
            rabbitProducerService.producerTopic("我是生产者，这是主题模式下的第" + i + "条信息");
            log.info("已发送第{}条消息", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
