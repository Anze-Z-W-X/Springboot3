package com.bjpowernode.jdbc;

import com.bjpowernode.jdbc.model.ArticleDetailPO;
import com.bjpowernode.jdbc.model.ArticleMainPO;
import com.bjpowernode.jdbc.model.ArticlePO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Lession09JdbdTplApplicationTests {

    //@Autowired  爆红但能运行
    @Resource   //不暴红
    private JdbcTemplate jdbcTemplate;
    @Test
    void t1(){
        String sql = "select count(*) as ct from article";
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("记录行数:"+aLong);
    }

    //测试“?”占位符
    @Test
    void testQuery() {
// ？作为占位符
        String sql = "select * from article where id= ? ";
//BeanPropertyRowMapper 将查询结果集，列名与属性名称匹配， 名称完全匹配或驼峰
        ArticlePO article = jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(ArticlePO.class), 1 );
        System.out.println("查询到的文章 = " + article);
    }

    @Test
    void test03(){
        String sql = "select * from article where id = 1";
        ArticlePO articlePO = jdbcTemplate.queryForObject(sql, ((rs, rowNum) -> {
            System.out.println("rs=" + rs);
            //从rs获取值
            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime())
                    .toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime())
                    .toLocalDateTime();
            return new ArticlePO(id, userId, title, summary, readCount,
                    createTime, updateTime);
        }));
        System.out.println(articlePO);
    }

    @Resource
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Test
    void testNameQuery() {
// :参数名
        String sql="select count(*) as ct from article where user_id=:uid and read_count > :num";
//key 是命名参数
        Map<String,Object> param = new HashMap<>();
        param.put("uid", 2101);
        param.put("num", 0);
        Long count = namedParameterJdbcTemplate.queryForObject(sql, param, Long.class);
        System.out.println("用户被阅读的文章数量 = " + count);
    }

    @Test
    void testQueryContent(){
        String sql = """
                select z.*,d.id as detail_id, d.article_id,d.content
                from article z join article_detail d
                on z.id = d.article_id
                where z.id=:id
                """;
        Map<String ,Object> param = new HashMap<>();
        param.put("id",1);
        List<ArticleMainPO> query = namedParameterJdbcTemplate.query(sql, param, (rs, rowNum) -> {
            var id = rs.getInt("id");
            var userId = rs.getInt("user_id");
            var title = rs.getString("title");
            var summary = rs.getString("summary");
            var readCount = rs.getInt("read_count");
            var createTime = new Timestamp(rs.getTimestamp("create_time").getTime())
                    .toLocalDateTime();
            var updateTime = new Timestamp(rs.getTimestamp("update_time").getTime())
                    .toLocalDateTime();
//文章详情
            var detailId = rs.getInt("detail_id");
            var content = rs.getString("content");
            var articleId = rs.getInt("article_id");
            ArticleDetailPO detail = new ArticleDetailPO();
            detail.setId(detailId);
            detail.setArticleId(articleId);
            detail.setContent(content);
            return new ArticleMainPO(id, userId, title, summary, readCount,
                    createTime, updateTime, detail);
        });
        query.forEach(System.out::println);
    }
}
