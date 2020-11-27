package com.example.gateway6010.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/27
 */
@RestController
@RequestMapping("/mock")
public class MockController {

    @PostMapping("/test/{id}")
    public String test(@PathVariable("id") String id){
        return "success:"+id;
    }
}
