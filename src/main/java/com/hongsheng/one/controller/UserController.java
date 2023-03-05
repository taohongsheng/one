package com.hongsheng.one.controller;

import com.hongsheng.one.entity.User;
import com.hongsheng.one.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "测试")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findUsersByName(@RequestParam("name") String name) {
        List<User> users = userService.findUsersByKeyword(name);
        return users;
    }
}
