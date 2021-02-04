package com.jiahao.per_demo.core.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Demo {
    @ApiModelProperty("主键id")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("创建时间")
    private Date createDate;
}
