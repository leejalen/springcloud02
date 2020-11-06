package com.example.customerfeign9002.controller;

import com.example.customerfeign9002.feign.Feign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/10/31
 * @author leejalen
 */
@Slf4j
@RestController
@RequestMapping("/customer9002")
@Api(value = "班级信息控制器", tags = "班级信息控制器")
public class ClassController {

    @Autowired
    private Feign feign;

    /**
     * 消费者获取服务者相关接口提供的服务
     * */
    @ApiOperation(value = "customer9002通过feign访问get接口服务", httpMethod = "POST")
    @PostMapping("/get")
    void getProviderClass(){
        feign.getProviderClass();
    }

    /**
     * 消费者获取服务者相关接口提供的服务
     * @param id 班级id
     * @return 相关班级信息
     * */
    @ApiOperation(value = "customer9002通过feign访问getById接口服务", httpMethod = "POST")
    @PostMapping("/get/{id}")
    String getProviderClassById(@PathVariable("id") String id){
        return feign.getProviderClassById(id);
    }
}
