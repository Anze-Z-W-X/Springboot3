package com.bjpowernode.quickweb.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ArticleVO {
    //add组
    public static interface addArticlGroup{};
    //edit组
    public static interface editArticleGroup{};

    @NotNull(groups = {editArticleGroup.class},message = "文章id必须有值")
    @Min(value = 1,message = "id大于0",groups = {editArticleGroup.class})
    private Integer id;
    @NotNull(message = "必须有作者!",groups = {addArticlGroup.class,editArticleGroup.class})
    private Integer userId;
    @NotBlank(message = "文章必须由标题",groups = {addArticlGroup.class,editArticleGroup.class})
    //@Size不会对null值做判断，需加上@NotNull或@NotBlank
    @Size(min=3,max = 30,message = "标题在3到30个字符间",groups = {addArticlGroup.class,editArticleGroup.class})
    private String title;
    @NotBlank(message = "必需有副标题",groups = {addArticlGroup.class,editArticleGroup.class})
    @Size(min=5,max = 60,groups = {addArticlGroup.class,editArticleGroup.class},message = "副标题在5到60个字符间")
    private String summary;
    @DecimalMin(value = "0",groups = {addArticlGroup.class,editArticleGroup.class},message = "阅读数不小于0")
    private Integer readCount;
    @Email(message = "邮箱不符合规则",groups = {addArticlGroup.class,editArticleGroup.class})
    private String email;
}
