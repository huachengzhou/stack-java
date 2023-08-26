package com.ttl.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : chengdu
 * @date :  2023/8/26-08
 **/
@Data
public class UserDto {
    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "年龄")
    private int age;
}
