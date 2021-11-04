package com.mantou.mapper;

import com.mantou.entity.Role;
import com.mantou.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {
    //查询角色
    @Select("select * from role")
    List<Role> findAllRole();
    //删除角色
    @Delete("delete from role where id = #{id}")
    int deleteRoleById(int id);
    //添加角色
    @Insert("insert into role (rolename) values (#{role.roleName})")
    int insertRole(@Param("role") Role role);
    //校验添加的角色是否重复
    @Select("select * from role where rolename = #{role.roleName}")
    Role findRoleByRoleName(@Param("role") Role role);
    //校验有没有用户使用该角色
    @Select("select * from user where roleid = #{id}")
    List<User> findUserByRoleId(int id);
}
