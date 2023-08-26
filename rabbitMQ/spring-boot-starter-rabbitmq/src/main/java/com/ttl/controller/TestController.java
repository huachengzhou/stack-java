package com.ttl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping(value = "/test")
@RestController
public class TestController {

    @RequestMapping(value = "/test",method = {RequestMethod.GET,RequestMethod.POST})
    public Object test(){
        return UUID.randomUUID().toString();
    }

}
