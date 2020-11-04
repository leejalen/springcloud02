package com.example.provider8002.controller;

import com.example.provider8002.service.IClassService;
import com.example.provider8002.service.bo.SpClassBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2020/10/31
 * @author leejalen
 */
@Slf4j
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private IClassService classService;

    @GetMapping("/get")
    public void getClassDto(){
        SpClassBO classBO = classService.selectClass("1");
        log.info(classBO.toString());
    }

    /**
     * 测试服务间调用
     * Provider8002使用RestTemplate通过IP地址调用Provider8001的服务
     * */
    @GetMapping("/testConnect")
    public void testConnectProvider8001(){
        RestTemplate restTemplate = new RestTemplate();
        String host = "http://localhost:8001"+"/class/discovery";
        restTemplate.getForObject(host, Object.class);
    }

}
