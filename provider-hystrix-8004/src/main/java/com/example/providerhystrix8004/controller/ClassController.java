package com.example.providerhystrix8004.controller;

import com.example.providerhystrix8004.controller.dto.SpClassDTO;
import com.example.providerhystrix8004.service.IClassService;
import com.example.providerhystrix8004.service.bo.SpClassBO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2020/10/31
 * @author leejalen
 */
@Slf4j
@RestController
@RequestMapping("/class8004")
public class ClassController {

    @Autowired
    private IClassService classService;

    @PostMapping("/get")
    public void getClassDto(){
        SpClassBO classBO = classService.selectClass("1");
        log.info(classBO.toString());
    }

    @PostMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "nullDataFallback")
    public SpClassDTO getClassById(@PathVariable("id") String id){
        SpClassBO classBO = classService.selectClass(id);
        log.info(classBO.toString());
        if (classBO.getClassId() == null){
            return null;
        }
        SpClassDTO classDTO = new SpClassDTO();
        BeanUtils.copyProperties(classBO, classDTO);
        return classDTO;
    }

    /**
     * Hystrix熔断器：若getClassById方法得不到有效数据返回，将默认调用nullDataFallback方法响应请求
     * 缺点:每个方法都要编写FallBack方法，增加了工作量，造成了代码膨胀，增大了维护难度，代码耦合度高，所以不合理，需要解耦
     * 解决方法：解耦和降级处理{在客户端完成，客户端在得不到服务后，自己回调本地地一个FallBack方法，返回缺省值 }
     * @param id 班级ID
     * */
    public SpClassDTO nullDataFallback(@PathVariable("id") String id){
        log.info("数据库没有数据");
        SpClassDTO classDTO = new SpClassDTO();
        classDTO.setClassId(id);
        classDTO.setClassName("null");
        classDTO.setSchoolId("null");
        return classDTO;
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
