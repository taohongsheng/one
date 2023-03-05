package com.hongsheng.one.controller;

import com.hongsheng.one.entity.User;
import com.hongsheng.one.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "修改模块")
@Controller
public class ModifyUserController {

    @Autowired
    UserService userService;

    //查询所有用户
    @RequestMapping("/users")
    public String showUsers(ModelMap modelMap) {
        List<User> userList = userService.queryAllUser();
        modelMap.addAttribute("userList", userList);
        return "users";
    }

    //新增用户
    @ApiOperation(value = "增加用户测试")
    @RequestMapping("/addUser")
    @ResponseBody
    public Map addUser(User user) {
        int flag = userService.addUser(user);
        Map<String, Object> map = new HashMap<String, Object>();
        if (flag == 1) {
            map.put("msg", "新增用户成功");
            return map;
        } else {
            map.put("msg", "新增用户失败");
            return map;
        }
    }

    //根据id查询用户
    @ApiOperation(value = "查询测试")
    @RequestMapping("/user+{id}")
    public String queryUser(@PathVariable("id") String id, ModelMap modelMap) {
        User user = userService.queryUserId(id);
        modelMap.addAttribute("user", user);
        return "userInfo";
    }

    @ApiOperation(value = "删除测试")
    //删除用户
    @RequestMapping(value = "/deleteUser+{id}")
    public String dropUser(@PathVariable("id") String id, ModelMap modelMap) {
        int flag = userService.dropUser(id);
        List<User> userList = userService.queryAllUser();
        modelMap.addAttribute("userList", userList);
        if (flag == 1) {
            return "users";

        } else {
            return "error";
        }
    }

    @ApiOperation(value = "修改测试")
    //修改用户信息
    @RequestMapping("/modifyUser")
    @ResponseBody
    public Map modifyUser(User user) {
        int flag = userService.modifyUser(user);
        Map<String, Object> map = new HashMap<>();
        if (flag == 1) {
            map.put("msg", "用户修改成功");
            return map;
        } else {
            map.put("msg", "用户信息修改失败");
            return map;
        }
    }

}
