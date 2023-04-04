package com.bjpowernode.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailPO {
    private Integer id;
    private Integer articleId;
    private String content;
}
