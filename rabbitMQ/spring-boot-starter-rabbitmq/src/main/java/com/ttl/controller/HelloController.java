package com.ttl.controller;

/**
 * @author : chengdu
 * @date :  2023/8/26-08
 **/

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
//说明该类的作用
@Api(tags = "一些测试用例")
public class HelloController {

    @GetMapping("one")
    @ApiOperation(value = "one方法，返回数据",notes = "这里可以写一些详细信息")
    public String one(){
        return  "one";
    }

    @PostMapping("two")
    @ApiOperation(value = "two方法，返回数据",notes = "这里可以写一些详细信息")
    public String two(){
        return  "two";
    }

    @DeleteMapping("three")
    @ApiOperation(value = "three方法，返回数据",notes = "这里可以写一些详细信息")
    public String three(){
        return  "three";
    }

    @GetMapping("add/{a}/{b}")
    @ApiOperation(value = "add方法，返回数据",notes = "这里可以写一些详细信息")
    public int add(@ApiParam(value = "参数a", required = true) @PathVariable int a ,
                   @ApiParam(value = "参数b", required = true)  @PathVariable int b){
        return  a+b;
    }
}


