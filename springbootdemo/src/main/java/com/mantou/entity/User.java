package com.mantou.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String jobNum;
    private Integer sex ;
    private Integer roleId ;
    private String roleName ;
}
