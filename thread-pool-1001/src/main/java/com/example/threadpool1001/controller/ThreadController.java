package com.example.threadpool1001.controller;

import com.example.threadpool1001.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/12/8
 */
@RestController
public class ThreadController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/thread")
    public void thread(){
        for (int i = 0; i < 100; i++) {
            asyncService.executeAsync();
        }
    }
}
