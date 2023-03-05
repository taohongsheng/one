package com.hongsheng.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/set")
    public String set(String key, String value) {
//        redisTemplate.opsForValue().set(key, value);
//        Map<String,String> result = new HashMap<>();
//        result.put("key",key);
//        result.put("value",value);
////        return "success";
//        return result.toString();
        redisTemplate.opsForValue().set(key, value, 100);
        Map<String, String> result = new HashMap<>();
        result.put("key", key);
        result.put("value", value);
        return result.toString();
    }

    @GetMapping("/get")
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

}