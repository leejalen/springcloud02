package com.example.rabbitmq5001.controller;

import com.example.rabbitmq5001.service.IRabbitProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * Created on 2020/11/11
 * @author leejalen
 */
@Controller
@RequestMapping("producer")
public class RabbitProducerController {

    @Autowired
    private IRabbitProducerService rabbitProducerService;

    @RequestMapping("/direct")
    public void direct() {
        for (int i = 0; i < 5; i++) {
            this.rabbitProducerService.producerDirect("我是生产者，这是路由模式下的第" + i + "条信息");
        }
    }

    @RequestMapping("/fanout")
    public void fanout() {
        for (int i = 0; i < 5; i++) {
            this.rabbitProducerService.producerFanout("我是生产者，这是发布订阅模式下的第" + i + "条信息");
        }
    }
}
