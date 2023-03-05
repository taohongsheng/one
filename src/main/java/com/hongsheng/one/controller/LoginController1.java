package com.hongsheng.one.controller;

import com.hongsheng.one.entity.User;
import com.hongsheng.one.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Api(tags = "redis+mysql")
@RestController
public class LoginController1 {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private UserService userService;

//    @GetMapping("/login1")
//    public Map<String, String> login(String name, String password) {
//        Map<String, String> result = new HashMap<>();
//        String storedPassword = (String) redisTemplate.opsForValue().get(name);
//        if (storedPassword == null || !storedPassword.equals(password)) {
//            User user = userService.loginIn(name, password);
//            if (user == null) {
//                result.put("result", "Error");
//                return result;
//            }
//            redisTemplate.opsForValue().set(name, password);
//        }
//        result.put("result", "Success");
//        return result;
//    }
    @GetMapping("/login2")
    public Map<String,String> login(String name,String password){
        Map<String,String> result = new HashMap<>();//初始化集合
        String np = (String) redisTemplate.opsForValue().get(name);//把从name中取出的密码转成字符串类型
        if (np == null||!np.equals(password)) {//判断密码是否为空和密码是否与提出的密码相同
            User user = userService.loginIn(name,password);//如果出现两种情况就去数据库比较
            if (user==null){
                result.put("result","error");
                return result;
            }
            redisTemplate.opsForValue().set(name,password);//如果比较成功了，就把他放到缓存中
        }
        result.put("result","success");
        return result;
    }

    }

