package com.bjpowernode.trans.service.impl;

import com.bjpowernode.trans.mapper.ArticleMapper;
import com.bjpowernode.trans.po.ArticleDetailPO;
import com.bjpowernode.trans.po.ArticlePO;
import com.bjpowernode.trans.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleServiceImpl implements ArticleService {
    //注入mapper
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    //事务回滚:
    //1.默认运行时异常执行rollback
    //2.rollbackFor：需要回滚的异常类型
    @Transactional(rollbackFor = {RuntimeException.class})
    public boolean postNewArticle(ArticlePO articlePO, String content) {
        //添加新的文章
        int rows = articleMapper.insertArticle(articlePO);

        //抛出异常
        if(articlePO.getReadCount()<1)
            throw new RuntimeException("文章阅读数量最小为1");

        //添加文章内容
        ArticleDetailPO articleDetailPO = new ArticleDetailPO();
        articleDetailPO.setArticleId(articlePO.getId());
        articleDetailPO.setContent(content);
        int dRows = articleMapper.insertDetail(articleDetailPO);

        return (rows+dRows)>=2;
    }
}
