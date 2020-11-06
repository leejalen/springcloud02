package com.example.provider8002.controller;

import com.example.provider8002.service.IClassService;
import com.example.provider8002.service.bo.SpClassBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/get")
    public void getClassDto(){
        SpClassBO classBO = classService.selectClass("1");
        log.info(classBO.toString());
    }

    @PostMapping("/get/{id}")
    public String getClassById(@PathVariable("id") String id){
        SpClassBO classBO = classService.selectClass(id);
        log.info(classBO.toString());
        return classBO.toString();
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
