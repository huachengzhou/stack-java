package com.ttl.controller;

import com.ttl.dto.UserDto;
import com.ttl.entity.AddUserParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chengdu
 * @date :  2023/8/26-08
 **/
@Api(tags={"用户接口"})
@RequestMapping(value = "/user_test")
@RestController
public class UserController {

    @RequestMapping(value = "/addUser",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiOperation(value="新增用户", notes="详细描述")
    public UserDto addUser(@ApiParam(value = "新增用户参数", required = true) @RequestBody AddUserParam param) {
        System.err.println(param.getName());
        return new UserDto();
    }
}
