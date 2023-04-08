package com.bjpowernode.quickweb.controller;

import com.bjpowernode.quickweb.vo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class JsonViewController {
    //显示json视图，包含json数据
    @RequestMapping("/exam/json")
    public void responseJson(HttpServletResponse response) throws IOException {
        String json = "{\"name\":\"lisi\",\"age\":20}";
        //应答,通过HttpServletResponse输出
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }

    //与@RequestMapping功能相似的注解:
    //1.@GetMapping:接受get请求
    //2.@PostMapping:接受post请求
    //3.@PutMapping:接受Put请求
    //4.@DeleteMapping

    //SpringMVC支持控制器方法返回对象,由框架将对象使用jackson转为json并输出
    @RequestMapping("/exam/json2")
    @ResponseBody
    public User getUserJson(){
        User user = new User();
        user.setUserName("张三");
        user.setAge(17);
        return user;
    }
}
