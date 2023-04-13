package com.bjpowernode.quickweb.controller;

import com.bjpowernode.quickweb.vo.RoleVO;
import com.bjpowernode.quickweb.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","赵四");
        modelAndView.addObject("age",17);
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @GetMapping("/json")
    @ResponseBody public User returnJson(){
        User user = new User();
        user.setAge(18);
        user.setUserName("anze");
        RoleVO roleVO = new RoleVO();
        roleVO.setRoleName("777");
        roleVO.setId(11);
        roleVO.setMemo("abab");
        user.setRoleVO(roleVO);

        return user;
    }

    @GetMapping("/json2")
    @ResponseBody public ResponseEntity<User> returnEntity(){
        User user = new User();
        user.setAge(18);
        user.setUserName("anze");
        RoleVO roleVO = new RoleVO();
        roleVO.setRoleName("777");
        roleVO.setId(11);
        roleVO.setMemo("abab");
        user.setRoleVO(roleVO);

        ResponseEntity<User> response = new ResponseEntity<>(user, HttpStatus.OK);

        return response;
    }

    //接收时间
    @GetMapping({"/param/date/{date}"})
    @ResponseBody public String paramDate(@PathVariable("date") LocalDateTime dateTime){
        return "时间:"+dateTime;
    }
}
