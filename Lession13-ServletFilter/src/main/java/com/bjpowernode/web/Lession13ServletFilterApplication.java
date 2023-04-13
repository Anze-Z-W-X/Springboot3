package com.bjpowernode.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//扫描@WebServlet注解
@ServletComponentScan(basePackages = "com.bjpowernode.web")
public class Lession13ServletFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession13ServletFilterApplication.class, args);
    }

}
