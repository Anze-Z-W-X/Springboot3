package com.bjpowernode.mvc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @PostMapping("/article/add")
    public String addArticle(){
        return "发布新文章";
    }

    @PostMapping("/article/edit")
    public String editArticle(){
        return "编辑文章";
    }

    @PostMapping("/article/query")
    public String queryArticle(){
        return "查询文章";
    }
}
