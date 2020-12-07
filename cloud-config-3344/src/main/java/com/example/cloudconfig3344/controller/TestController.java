package com.example.cloudconfig3344.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/12/7
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test(){
        return "success";
    }

}
