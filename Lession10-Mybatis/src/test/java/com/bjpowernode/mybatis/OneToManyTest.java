package com.bjpowernode.mybatis;

import com.bjpowernode.mybatis.mapper.OneToMoreMapper;
import com.bjpowernode.mybatis.po.ArticleOneToMore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneToManyTest {
    @Autowired
    OneToMoreMapper oneToMoreMapper;

    @Test
    void test01(){
        ArticleOneToMore articleOneToMore = oneToMoreMapper.selectArticleComments(1);
        System.out.println("articleOneToMore = " + articleOneToMore);
    }
}
