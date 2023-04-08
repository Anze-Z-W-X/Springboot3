package com.bjpowernode.trans.mapper;

import com.bjpowernode.trans.po.ArticleDetailPO;
import com.bjpowernode.trans.po.ArticlePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface ArticleMapper {

    //添加文章属性Article
    @Insert("""
            insert into article(user_id,title,summary,read_count,create_time,update_time)
            values(#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
            """)
    //可选的配置，获得自动增长的主键值赋值给articlePO的id
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insertArticle(ArticlePO articlePO);

    //添加的文章内容 Article_Detail
    @Insert("""
            insert into article_detail(article_id,content)
            values(#{articleId},#{content})
            """)
    int insertDetail(ArticleDetailPO articleDetailPO);
}
