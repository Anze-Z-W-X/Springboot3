package com.bjpowernode.quickweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

//@Controller：创建控制器对象，控制器能接受请求，响应结果给浏览器
@Controller
public class QuickController {

    @RequestMapping("/exam/quick")
    //Model表示模型，存储数据，这个数据最后放在request作用域中
    public String quick(Model model){
        model.addAttribute("title","Web开发");
        model.addAttribute("time", LocalDateTime.now());

        //指定视图，显示数据
        return "quick";
    }
}
