package com.example.provider8001.controller;

import com.example.provider8001.service.IClassService;
import com.example.provider8001.service.bo.SpClassBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created on 2020/10/31
 * @author: leejalen
 */
@Slf4j
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private IClassService classService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get")
    public void getClassDto(){
        SpClassBO classBO = classService.selectClass("1");
        log.info(classBO.toString());
    }

    /**
     * 测试方法
     * 发现eureka中所有服务的信息
     * */
    @GetMapping("/discovery")
    public void discovery(){
        //eureka中Application名列表
        List<String> list = discoveryClient.getServices();
        log.info("Application名列表 : {}", list);
        //eureka中Status名列表
        List<ServiceInstance> instanceList = discoveryClient.getInstances("PROVIDER8001");
        for (ServiceInstance instance : instanceList){
            log.info("Status名列表 : {}", instance);
            String appId = instance.getServiceId();
            String scheme = instance.getScheme();
            String instanceId = instance.getInstanceId();
            String host = instance.getHost();
            int port = instance.getPort();
            URI uri = instance.getUri();
            Map<String, String> metaData = instance.getMetadata();
            log.info("appId应用对外暴露的名字 : {}", appId);
            log.info("scheme : {}", scheme);
            log.info("instanceId应用在eureka中的别名 : {}", instanceId);
            log.info("host应用所在的主机IP : {}", host);
            log.info("port应用端口号 : {}", port);
            log.info("uri应用真实IP地址 : {}", uri);
            log.info("metaData应用元数据 : {}", metaData);
        }
    }

}
