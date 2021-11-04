package com.mantou.service;

import com.mantou.entity.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface UserService {
    PageResult findAllUser(User_InfoListRequest user_infoListRequest);

    Integer insertUser(User user);

    Integer deleteUserById(int id);

    Integer updateUserById(User user);

    User findUserById(int id);

    void exportUserInfo(HttpServletRequest request, HttpServletResponse response);
}
