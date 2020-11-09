package com.example.customerfeignhystrix9003.controller;

import com.example.customerfeignhystrix9003.feign.FeignClientService;
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
@RequestMapping("/class9003")
@Api(value = "班级信息控制器", tags = "班级信息控制器")
public class ClassController {

    @Autowired
    private FeignClientService feignClientService;

    /**
     * 消费者获取服务者相关接口提供的服务
     * */
    @ApiOperation(value = "customer9003通过feign和hystrix访问get接口服务", httpMethod = "POST")
    @PostMapping("/get")
    void getProviderClass(){
        feignClientService.getProviderClass();
    }

    /**
     * 消费者获取服务者相关接口提供的服务
     * @param id 班级id
     * @return 相关班级信息
     * */
    @ApiOperation(value = "customer9002通过feign和hystrix访问getById接口服务", httpMethod = "POST")
    @PostMapping("/get/{id}")
    String getProviderClassById(@PathVariable("id") String id){
        return feignClientService.getProviderClassById(id);
    }
}
