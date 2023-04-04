CREATE TABLE IF NOT EXISTS `article`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`     int(11) NOT NULL COMMENT '作者 ID',
    `title`       varchar(100) NOT NULL COMMENT '文章标题',
    `summary`     varchar(200) DEFAULT NULL COMMENT '文章概要',
    `read_count`  int(11) unsigned zerofill NOT NULL COMMENT '阅读读数',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_time` datetime     NOT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;