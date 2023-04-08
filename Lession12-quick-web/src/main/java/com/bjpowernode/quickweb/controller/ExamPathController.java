package com.bjpowernode.quickweb.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamPathController {
    @RequestMapping("/file/t?st.html")
    public String path1(HttpServletRequest request){
        return "path动态:"+request.getRequestURI();
    }
    @RequestMapping("/images/*.gif")
    public String path2(HttpServletRequest request){
        return "path2:"+request.getRequestURI();
    }
    @RequestMapping("/order/{*id}")
    public String path3(@PathVariable("id")String orderId,HttpServletRequest request){
        return "path3:"+request.getRequestURI()+",id:"+orderId;
    }
    @RequestMapping("/pages/{fname:\\w+}.log")
    public String path4(@PathVariable("fname")String fname,HttpServletRequest request){
        return "path4:"+request.getRequestURI()+",fname:"+fname;
    }
}
