package com.bjpowernode.mybatis.provider;

public class SqlProvider {
    public static String selectArticle(){
        return "select * from article where id=#{id}";
    }

    public static String updateSql(){
        return "update article set update_time=#{newTime} where id = #{id}";
    }
}
