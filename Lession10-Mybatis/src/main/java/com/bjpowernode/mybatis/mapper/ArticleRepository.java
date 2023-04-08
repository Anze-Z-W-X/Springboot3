package com.bjpowernode.mybatis.mapper;

import com.bjpowernode.mybatis.po.ArticlePO;
import com.bjpowernode.mybatis.provider.SqlProvider;
import org.apache.ibatis.annotations.*;

public interface ArticleRepository {

    //定义Results
    @Select("")
    @Results(id = "BaseArticleMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "read_count",property = "readCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
    })
    ArticlePO articleMapper();

    @SelectProvider(type = com.bjpowernode.mybatis.provider.SqlProvider.class,method = "selectArticle")
    @ResultMap("BaseArticleMap")
    ArticlePO selectByPrimary(Integer id);
}
