package com.bjpowernode.trans.service;

import com.bjpowernode.trans.po.ArticlePO;

public interface ArticleService {
    //发布新的文章

    boolean postNewArticle(ArticlePO articlePO,String content);
}
