package com.bjpowernode.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentPO {
    private Integer id;
    private Integer articleId;
    private String comment;
}
