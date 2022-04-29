package com.mantou.controller;

import com.mantou.entity.*;
import com.mantou.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@Api(tags = "后台UserController")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/findAllUser")
    @ApiOperation(value = "查询所有用户信息")
    public PageResult findAllUser(User_InfoListRequest user_infoListRequest) {
        PageResult allUser = userService.findAllUser(user_infoListRequest);
        log.info("allUser:{}",allUser);
        return allUser ;
    }
    @PostMapping("/insertUser")
    @ApiOperation(value = "新增用户")
    public AppMessage insertUser(@RequestBody User user) {
        return AppMessage.success(userService.insertUser(user));
    }

    @PostMapping("/deleteUserById")
    @ApiOperation(value = "删除用户")
    public AppMessage deleteUserById(@Param("id") int id) {
        log.info("id:{}",id);
        return AppMessage.success(userService.deleteUserById(id));
    }

    @PostMapping("/updateUserById")
    @ApiOperation(value = "编辑用户")
    public AppMessage updateUserById(@RequestBody User user) {
        log.info("User:{}",user);
        return AppMessage.success(userService.updateUserById(user));
    }

    @GetMapping("/findUserById")
    @ApiOperation(value = "根据id查询用户")
    public AppMessage findUserById(int id) {
        return AppMessage.success(userService.findUserById(id));
    }

    @GetMapping(value = "/exportUserInfo")
    @ApiOperation(value = "导出excel")
    public void exportUserInfo(HttpServletRequest request, HttpServletResponse response) {
        //得到所有要导出的数据
         userService.exportUserInfo(request,response);
    }


}
