package com.bjpowernode.trans;

import com.bjpowernode.trans.po.ArticlePO;
import com.bjpowernode.trans.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
class Lession11TransApplicationTests {
    @Autowired
    private ArticleService articleService;

    @Test
    void test01() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setTitle("Spring事务管理");
        articlePO.setSummary("基于spring的注解管理事务，进行事务控制");
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setReadCount(new Random().nextInt(1000));

        String content = "基于Spring的注解管理事务，进行事务控制：1.声明式；2.编程式";
        boolean b = articleService.postNewArticle(articlePO,content);

        System.out.println("发布新文章:"+b);
    }

    @Test
    void testTrans() {
        ArticlePO articlePO = new ArticlePO();
        articlePO.setUpdateTime(LocalDateTime.now());
        articlePO.setCreateTime(LocalDateTime.now());
        articlePO.setTitle("Spring事务管理");
        articlePO.setSummary("基于spring的注解管理事务，进行事务控制");
        articlePO.setUserId(new Random().nextInt(500));
        articlePO.setReadCount(0);

        String content = "基于Spring的注解管理事务，进行事务控制：1.声明式；2.编程式";
        boolean b = articleService.postNewArticle(articlePO,content);

        System.out.println("发布新文章:"+b);
    }

}
