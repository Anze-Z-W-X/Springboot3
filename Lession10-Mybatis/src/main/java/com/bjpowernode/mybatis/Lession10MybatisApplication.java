package com.bjpowernode.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.bjpowernode.mybatis.mapper")
public class Lession10MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession10MybatisApplication.class, args);
    }

}
