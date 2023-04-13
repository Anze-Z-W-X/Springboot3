package com.bjpowernode.quickweb.controller;

import com.bjpowernode.quickweb.vo.ArticleVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    //发布新文章:(@Validated表示验证bean对象,BindingResult表示验证结果是否通过)
    @PostMapping("/article/add")
    public Map<String ,Object> addArticle(@Validated(ArticleVO.addArticlGroup.class) @RequestBody ArticleVO articleVO, BindingResult br){
        //service方法处理文章的业务

        //返回结果数据
        Map<String,Object> map = new HashMap<>();
        if(br.hasErrors()) {
            List<FieldError> fieldErrors = br.getFieldErrors();

            for(int i=0;i<fieldErrors.size();i++){
                FieldError field = fieldErrors.get(i);
                map.put(i+"-"+field.getField(),field.getDefaultMessage());
            }
        }
        return map;
    }

    //编辑新文章:(@Validated表示验证bean对象,BindingResult表示验证结果是否通过)
    @PostMapping("/article/edit")
    public Map<String ,Object> editArticle(@Validated(ArticleVO.editArticleGroup.class) @RequestBody ArticleVO articleVO, BindingResult br){
        //service方法处理文章的业务

        //返回结果数据
        Map<String,Object> map = new HashMap<>();
        if(br.hasErrors()) {
            List<FieldError> fieldErrors = br.getFieldErrors();

            for(int i=0;i<fieldErrors.size();i++){
                FieldError field = fieldErrors.get(i);
                map.put(i+"-"+field.getField(),field.getDefaultMessage());
            }
        }
        return map;
    }
}
