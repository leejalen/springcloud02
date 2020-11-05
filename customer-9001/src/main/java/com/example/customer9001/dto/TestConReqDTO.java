package com.example.customer9001.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created on 2020/11/5
 * @author leejalen
 */
@Data
@ApiModel(value = "测试连接请求对象", description = "测试连接请求对象")
public class TestConReqDTO {

    @NotBlank
    @ApiModelProperty(value = "应用ID名称", example = "provider8001", required = true)
    private String appID;

    @NotBlank
    @ApiModelProperty(value = "连接的接口路径", example = "/class/discovery", required = true)
    private String conPath;
}
