package com.hongsheng.one.controller;

import com.hongsheng.one.entity.User;
import com.hongsheng.one.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "根据id查询")
@RestController
public class NamePasswordController {
    @Autowired
    private UserService userService;

    @RequestMapping("/name")
    public String namepassword(String id) {
        List<User> users = userService.namePasswordById(id);
        return users.toString();


    }


}
