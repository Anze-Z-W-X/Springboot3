package com.bjpowernode.mybatis.mapper;

import com.bjpowernode.mybatis.po.ArticlePO;
import org.apache.ibatis.annotations.*;

public interface ArticleMapper {
    //按主键查询
    @Select("""
            select id,user_id,title,summary,read_count,create_time,update_time
            from article where id = #{article}
            """)
    //查询结果ResultSet 和 PO对象的属性的映射
    @Results(id = "BaseArticleMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "read_count",property = "readCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
    })
    ArticlePO selectById(@Param("article") Integer id);

    //insert
    @Insert("""
            insert into article(user_id,title,summary,read_count,create_time,update_time)
            values(#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
            """)
    int insertArticle(ArticlePO articlePO);
}
