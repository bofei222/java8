package com.bf.reflection;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {

    private Integer userId;

    @MyPDF(value = "名称")
    @ApiModelProperty(value = "名称")
    private String userName;

    @MyPDF(value = "名称")
    @ApiModelProperty(value = "编码")
    private String code;

//    @MyPDF
    @ApiModelProperty(value = "地址")
    private String address;
}
