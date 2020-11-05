package com.example.customer9001.controller;

import com.example.customer9001.dto.TestConReqDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created on 2020/10/31
 * @author leejalen
 */
@Slf4j
@RestController
@RequestMapping("/class")
@Api(value = "班级信息控制器", tags = "班级信息控制器")
public class ClassController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 测试服务间调用
     * Provider8002使用RestTemplate通过IP地址调用Provider8001的服务
     * */
    @PostMapping("/testConnect")
    @ApiOperation(value = "测试连接Provider8001", httpMethod = "POST")
    public void testConnectProvider8001(@Validated @RequestBody TestConReqDTO reqDTO){
        String appID = reqDTO.getAppID();
        String conPath = reqDTO.getConPath();
        List<String> list = discoveryClient.getServices();
        if (!list.contains(appID)){
            log.info("应用 {} 未在eureka中注册", appID);
            return;
        }

        List<ServiceInstance> instanceList = discoveryClient.getInstances(appID);
        ServiceInstance firstInstance = instanceList.get(0);
        URI uri = firstInstance.getUri();

        RestTemplate restTemplate = new RestTemplate();
        String appAddress = uri.toString() + conPath;
        restTemplate.getForObject(appAddress, Object.class);
    }

}
