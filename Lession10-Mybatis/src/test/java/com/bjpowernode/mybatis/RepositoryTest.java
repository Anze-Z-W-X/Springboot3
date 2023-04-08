package com.bjpowernode.mybatis;

import com.bjpowernode.mybatis.mapper.ArticleRepository;
import com.bjpowernode.mybatis.po.ArticlePO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;
    @Test
    void test01(){
        ArticlePO articlePO = articleRepository.selectByPrimary(1);
        System.out.println("articlePO = " + articlePO);
    }

}
