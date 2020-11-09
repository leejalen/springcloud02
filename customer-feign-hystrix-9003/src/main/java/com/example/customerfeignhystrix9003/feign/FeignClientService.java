package com.example.customerfeignhystrix9003.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created on 2020/11/6
 * @author leejalen
 */
@FeignClient(value = "provider", fallbackFactory = HystrixFallbackFactory.class)
public interface FeignClientService {

    /**
     * 消费者获取服务者相关接口提供的服务
     * */
    @PostMapping("class/get")
    void getProviderClass();

    /**
     * 消费者获取服务者相关接口提供的服务
     * @param id 班级id
     * @return 相关班级信息
     * */
    @PostMapping("class/get/{id}")
    String getProviderClassById(@PathVariable("id") String id);
}
