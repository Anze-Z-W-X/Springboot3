package com.bjpowernode.mybatis.mapper;

import com.bjpowernode.mybatis.po.ArticleOneToMore;
import com.bjpowernode.mybatis.po.CommentPO;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OneToMoreMapper {

    @Select("""
            select id,article_id,comment from comment
            where article_id=#{articleId}
            """)
    @Results(value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "article_id",property = "articleId"),
            @Result(column = "comment",property = "comment")
    })
    List<CommentPO> selectComments(Integer articleId);

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
            many = @Many(select = "com.bjpowernode.mybatis.mapper.OneToMoreMapper.selectComments",
            fetchType = FetchType.LAZY)
            )})
    ArticleOneToMore selectArticleComments(Integer Id);
}
