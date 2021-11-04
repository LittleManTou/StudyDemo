package com.mantou.mapper;

import com.mantou.entity.User;
import com.mantou.entity.UserExport;
import com.mantou.entity.User_InfoListRequest;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有
    @Select("<script>" + "select * from user u , role r"
            + " <where>  u.roleid = r.id "
            +"<if test='userInfo.userName != null '> and username like '%${userInfo.userName}%' </if>"
            +"<if test='userInfo.jobNum != null '> and jobnum like '%${userInfo.jobNum}%' </if>"
            +"<if test='userInfo.sex != 2'> and sex = '${userInfo.sex}' </if>"
            +"</where>"
            +"</script>")
    List<User> findAllUser(@Param("userInfo") User_InfoListRequest userInfo);
    //添加
    @Insert("insert into user (username,jobnum,sex,roleid) values (#{user.userName},#{user.jobNum},#{user.sex},#{user.roleId})")
    int insertUser(@Param("user") User user);
    //删除
    @Delete("delete from user where id = #{id}")
    int deleteUserById(int id);
    //更新
    @Update("update user set username = #{user.userName} , jobNum = #{user.jobNum} , sex = #{user.sex} ,roleid = #{user.roleId} where id = #{user.id}")
    int updateUserById(@Param("user") User user);
    //编辑
    @Select("select * from user u ,role r where u.roleid = r.id and u.id = #{id}")
    User findUserById(int id);
    //校验工号
    @Select("select * from user where jobnum = #{user.jobNum}")
    List<User> findUser(@Param("user") User user);
    //导出用户信息
    @Select("<script>" +
            "SELECT u.id,u.username,u.jobnum,CASE u.sex WHEN '1' THEN '男' ELSE '女' END AS sex ,r.rolename from user u,role r WHERE u.roleid = r.id "
            +"<if test='userName != null '> and username like '%${userName}%' </if>"
            +"<if test='jobNum != null '> and jobnum like '%${jobNum}%' </if>"
            +"<if test='sex != 2'> and sex = '${sex}' </if>"
            +"</script>")
    List<UserExport> exportAllUserInfo(String userName,String jobNum,String sex);
}
