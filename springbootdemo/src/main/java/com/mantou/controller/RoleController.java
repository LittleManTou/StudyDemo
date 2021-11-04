package com.mantou.controller;

import com.mantou.entity.AppMessage;
import com.mantou.entity.PageRequest;
import com.mantou.entity.PageResult;
import com.mantou.entity.Role;
import com.mantou.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@Api(tags = "后台RoleController")
@Slf4j
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/pageHelperRole")
    @ApiOperation(value = "查询所有角色信息")
    public PageResult pageHelperRole(PageRequest pageRequest) {
        PageResult allRole = roleService.pageHelperRole(pageRequest);
        return allRole ;
    }

    @GetMapping("/findAllRole")
    @ApiOperation(value = "查询角色信息")
    public AppMessage findAllRole() {
        return AppMessage.success(roleService.findAllRole());
    }


    @PostMapping("/deleteRoleById")
    @ApiOperation(value = "删除角色")
    public AppMessage deleteRoleById(int id){
        return AppMessage.success(roleService.deleteRoleById(id)) ;
    }


    @PostMapping("/insertRole")
    @ApiOperation(value = "添加角色")
    public AppMessage insertRole(@RequestBody Role role){
        return AppMessage.success(roleService.insertRole(role));
    }



}
