package com.example.demotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @RequestMapping("/aa")
    public String test(){
        return "welcome";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String show (){
        return "HELLO";
    }
}
