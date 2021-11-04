package com.mantou.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mantou.entity.PageRequest;
import com.mantou.entity.PageResult;
import com.mantou.entity.Role;
import com.mantou.entity.User;
import com.mantou.mapper.RoleMapper;
import com.mantou.service.RoleService;
import com.mantou.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper ;
    //分页查询role表
    @Override
    public PageResult pageHelperRole(PageRequest pageRequest) {
        PageResult pageResult = PageUtils.getPageResult(pageRequest, getPageInfoRole(pageRequest));
        return pageResult;
    }



    // role分页查询
    private PageInfo<Role> getPageInfoRole(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Role> sysMenus = roleMapper.findAllRole();
        return new PageInfo<Role>(sysMenus);
    }

    //查询角色表信息
    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    //删除角色
    @Override
    public Integer deleteRoleById(int id) {
        List<User> users = roleMapper.findUserByRoleId(id);
        if (!users.isEmpty()) return 0 ;   //表示有用户与该角色关联
        return roleMapper.deleteRoleById(id);
    }
    //增加角色
    @Override
    public Integer insertRole(Role role) {
        Role rName = roleMapper.findRoleByRoleName(role);
        if (rName != null) return 0 ;
        return roleMapper.insertRole(role);
    }
}
