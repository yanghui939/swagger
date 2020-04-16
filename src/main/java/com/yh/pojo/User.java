package com.yh.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter  //生成get方法
@Setter  //生成set方法
@NoArgsConstructor // 生成无参构造
@AllArgsConstructor   //生成有参构造
@ApiModel
public class User {
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("用户密码")
    private String password;
}
