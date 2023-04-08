package com.bjpowernode.mybatis.mapper;

import com.bjpowernode.mybatis.po.Article;
import com.bjpowernode.mybatis.po.ArticleDetail;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface OneToOneMapper {

    @Select("""
            select id,article_id,content from article_detail
            where article_id = #{articleId};
            """)
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "article_id", property = "articleId"),
            @Result(column = "content", property = "content")
    })
    ArticleDetail selectDetail(Integer articleId);

    @Select("""
            select id,user_id,title,summary,read_count,create_time,update_time
            from article where id=#{id}
            """)
    @Results(id = "BaseArticleMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "read_count",property = "readCount"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime"),
            @Result(column = "id",property = "commentPOList",
                    one = @One(select = "com.bjpowernode.mybatis.mapper.OneToOneMapper.selectDetail",
                    fetchType = FetchType.LAZY))
    })
    Article selectAllArticle(Integer id);

}
