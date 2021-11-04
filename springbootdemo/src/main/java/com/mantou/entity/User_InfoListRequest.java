package com.mantou.entity;

import lombok.Data;

@Data
public class User_InfoListRequest extends PageRequest{
    private String userName;
    private String jobNum;
    private Integer sex;
}
