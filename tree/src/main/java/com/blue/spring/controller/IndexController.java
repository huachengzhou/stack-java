package com.blue.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/22
 **/
@Controller
public class IndexController {

    @RequestMapping(value = "/index",method = {RequestMethod.GET},name = "http://localhost:9099/tree/index")
    public String index(){
        return "index";
    }
}
