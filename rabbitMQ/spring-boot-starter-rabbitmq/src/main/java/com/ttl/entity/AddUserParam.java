package com.ttl.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : chengdu
 * @date :  2023/8/26-08
 **/
@Data
@ApiModel(value = "com.znzz.user", description = "新增用户参数")
public class AddUserParam {
    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "年龄")
    private int age;
}

