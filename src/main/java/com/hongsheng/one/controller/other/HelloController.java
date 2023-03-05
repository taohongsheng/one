package com.hongsheng.one.controller.other;


import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Api(tags = "好看的模块")
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String sayHello(){
        return "index";
    }
}
