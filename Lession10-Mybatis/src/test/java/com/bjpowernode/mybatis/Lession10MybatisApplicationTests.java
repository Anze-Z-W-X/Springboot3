package com.bjpowernode.mybatis;

import com.bjpowernode.mybatis.mapper.ArticleDao;
import com.bjpowernode.mybatis.mapper.ArticleMapper;
import com.bjpowernode.mybatis.po.ArticlePO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class Lession10MybatisApplicationTests {

    @Autowired
    private ArticleMapper articleMapper;
    @Test
    void mybatisTest() {
        ArticlePO articlePO = articleMapper.selectById(1);
        System.out.println(articlePO);
    }

    @Test
    void testInsert(){
        ArticlePO article=new ArticlePO();
        article.setTitle("什么时候用微服务");
        article.setSummary("微服务优缺点");
        article.setUserId(219);
        article.setReadCount(560);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.insertArticle(article);
    }

    @Autowired
    private ArticleDao articleDao;

    @Test
    void test02(){
        List<ArticlePO> articlePOS = articleDao.selectList(219);
        articlePOS.forEach(System.out::println);
    }

}
