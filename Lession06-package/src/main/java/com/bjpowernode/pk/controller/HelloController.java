package com.bjpowernode.pk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "欢迎使用SpringBoot3!";
    }
}
