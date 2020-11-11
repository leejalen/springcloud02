package com.example.rabbitmq5001.controller;

import com.example.rabbitmq5001.service.IRabbitProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * Created on 2020/11/11
 * @author leejalen
 */
@RestController
@RequestMapping("/producer")
public class RabbitProducerController {

    @Autowired
    private IRabbitProducerService rabbitProducerService;

    @PostMapping("/test")
    public String test(){
        return "success";
    }

    @PostMapping("/direct")
    public void direct() {
        for (int i = 0; i < 5; i++) {
            this.rabbitProducerService.producerDirect("我是生产者，这是路由模式下的第" + i + "条信息");
            System.out.println("已发送"+i);
        }
    }

    @PostMapping("/fanout")
    public void fanout() {
        for (int i = 0; i < 5; i++) {
            this.rabbitProducerService.producerFanout("我是生产者，这是发布订阅模式下的第" + i + "条信息");
        }
    }
}
