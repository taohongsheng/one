package com.hongsheng.one.controller;

import com.hongsheng.one.entity.User;
import com.hongsheng.one.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;
import java.util.HashMap;

@Api(tags = "登录模块")
@Controller
public class LoginController {
    @Autowired
    UserService userService;
   RedisTemplate redisTemplate;
    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
//    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "name",value = "姓名",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)
    })
    @ApiOperation(value = "登录测试")
    @GetMapping("/loginIn")
    public String login(String name,String password){
        User user = userService.loginIn( name,password);
        if(user!=null){
            return "success";
        }else {
            return "error";
        }
    }

}
