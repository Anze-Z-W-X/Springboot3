package com.bjpowernode.quickweb.vo;

import lombok.Data;

@Data
public class User {
    private String userName;
    private Integer age;
    private RoleVO roleVO;
}
