package com.yh.controller;

import com.yh.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     //返回josn格式并标记该类为controller类
@RequestMapping("/user")  //指定在路径前加一个统一路径
@Api(tags = "用户相关接口")  //描述该类的作用
public class UserController {

    @GetMapping("/findById")   //指定路径
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id")    //给参数备注
    })
    @ApiOperation(value = "根据id查询用户",notes = "查询指定id的用户",httpMethod = "GET")   //给方法描述作用，以及访问方式
    public User findById(Integer id) {
        User user = new User(id, "zhangsan", "123456");
        return user;
    }
}
