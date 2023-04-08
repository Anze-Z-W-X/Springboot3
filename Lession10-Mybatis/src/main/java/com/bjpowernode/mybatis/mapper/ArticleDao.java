package com.bjpowernode.mybatis.mapper;

import com.bjpowernode.mybatis.po.ArticlePO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleDao {

    @Select("""
    select id,user_id,title,summary,read_count,create_time,update_time
    from article where user_id=${userId}
            """)
    @Results(id = "BaseMapper", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "read_count", property = "readCount"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime"),
    })
    List<ArticlePO> selectList(Integer userId);

    @Select("""
select id,user_id,title,summary,read_count,create_time,update_time
from article where id=#{articleId}
""")
    @ResultMap("BaseMapper")
    ArticlePO selectById(@Param("articleId") Integer id);
}
