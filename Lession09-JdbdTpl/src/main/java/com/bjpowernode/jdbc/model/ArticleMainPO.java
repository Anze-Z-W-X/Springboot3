package com.bjpowernode.jdbc.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleMainPO {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private ArticleDetailPO detailPO;
}
