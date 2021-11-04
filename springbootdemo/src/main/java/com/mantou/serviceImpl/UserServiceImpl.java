package com.mantou.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mantou.entity.*;
import com.mantou.mapper.UserMapper;
import com.mantou.service.UserService;
import com.mantou.utils.ExportExcelUtil;
import com.mantou.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //查询所有用户
    @Override
    public PageResult findAllUser(User_InfoListRequest user_infoListRequest) {
        if (user_infoListRequest.getUserName() == "") user_infoListRequest.setUserName(null);
        if (user_infoListRequest.getJobNum() == "") user_infoListRequest.setJobNum(null);
        //log.info("userName:{},jobNum:{},sex:{}",user_infoListRequest.getUserName(),user_infoListRequest.getJobNum(),user_infoListRequest.getSex());
        PageResult pageResult = PageUtils.getPageResult(user_infoListRequest, getPageInfo(user_infoListRequest));
        return pageResult ;
    }
    //新增用户
    @Override
    public Integer insertUser(User user) {
        log.info("InsertUser:{}",user);
        List<User> users = userMapper.findUser(user);
        if (!users.isEmpty()){
            return 0;   //表示工号已经存在
        }
        int i = userMapper.insertUser(user);
        if (i == 0) return 1;
        return 2;
    }
    //删除用户
    @Override
    public Integer deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }
    //更新用户
    @Override
    public Integer updateUserById(User user) {
        User userById = userMapper.findUserById(user.getId());   //查询原来的工号
        List<User> users = userMapper.findUser(user);   //查询更改后有没有重复
        if (!users.isEmpty()){
            for (int i = 0; i < users.size(); i++) {
                log.info("size:{}",users.size());
                log.info("userByIdJobNum:{}",userById.getJobNum());
                log.info("jobNum:{}",users.get(i).getJobNum());
                if (!users.get(i).getJobNum().equals(userById.getJobNum()) ) {
                    return 0;  //表示工号已经存在
                }
            }
        }
        int i = userMapper.updateUserById(user);
        log.info("i：{}",i);
        if (i == 0) {
            return 1;
        }
        return 2 ;

    }
    //根据Id查询用户
    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    //查询所有分页
    private PageInfo<User> getPageInfo(User_InfoListRequest user_infoListRequest) {
        int pageNum = user_infoListRequest.getPageNum();
        int pageSize = user_infoListRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userMapper.findAllUser(user_infoListRequest);
        return new PageInfo<User>(sysMenus);
    }

    //导出用户信息
    @Override
    public void exportUserInfo(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("userName");
        String jobNum = request.getParameter("jobNum");
        String sex = request.getParameter("sex");
        log.info("userName:{},jobNum:{},sex:{}",userName,jobNum,sex);

        List<UserExport> orderlist = userMapper.exportAllUserInfo(userName,jobNum,sex);
        //定义导出的excel名字
        String excelName = "用户信息";
        //获取需要转出的excel表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("id", "编号");
        fieldMap.put("userName", "姓名");
        fieldMap.put("jobNum", "工号");
        fieldMap.put("sex", "性别");
        fieldMap.put("roleName", "角色");
        //导出用户相关信息
        new ExportExcelUtil().export(excelName, orderlist, fieldMap, response);
    }


}
