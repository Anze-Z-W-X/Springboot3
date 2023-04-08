package com.bjpowernode.trans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//可选，默认开启的
@SpringBootApplication
@MapperScan(basePackages = "com.bjpowernode.trans.mapper")
public class Lession11TransApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lession11TransApplication.class, args);
    }

}
