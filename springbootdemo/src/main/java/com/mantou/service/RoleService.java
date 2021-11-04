package com.mantou.service;

import com.mantou.entity.PageRequest;
import com.mantou.entity.PageResult;
import com.mantou.entity.Role;
import java.util.List;

public interface RoleService {

    PageResult pageHelperRole(PageRequest pageRequest);

    List<Role> findAllRole();

    Integer deleteRoleById(int id);

    Integer insertRole(Role role);

}
