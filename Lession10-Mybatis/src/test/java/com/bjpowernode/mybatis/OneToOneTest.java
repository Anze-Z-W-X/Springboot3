package com.bjpowernode.mybatis;

import com.bjpowernode.mybatis.mapper.OneToOneMapper;
import com.bjpowernode.mybatis.po.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToOneTest {
    @Autowired
    OneToOneMapper oneToOneMapper;

    @Test
    void test01(){
        Article article = oneToOneMapper.selectAllArticle(1);
        System.out.println("article = " + article);
    }
}
