package com.bjhxqh.web;



import com.bjhxqh.common.response.Response;
import com.bjhxqh.mybatis.model.po.SysRole;
import com.bjhxqh.service.SysRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017-07-20.
 */

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private SysRoleService roleService;

    @ApiOperation(value = "获取角色列表")
    @GetMapping("/")
    public Response getList(SysRole role) {
        return new Response().success(roleService.selectByRole(role));
    }

    @ApiOperation(value = "获取角色详情")
    @GetMapping("/{id}")
    public Response getUserById(@PathVariable Long id) {
        SysRole role = new SysRole();
        role.setId(id);
        role = roleService.selectByEntity(role);
        return new Response().success(role);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("/")
    public Response postUser(@RequestBody SysRole role) {
        int isExc = roleService.save(role);
        return new Response().success(role);
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("/{id}")
    public Response putUser(@PathVariable Long id, @RequestBody SysRole role) {
        role.setId(id);
        roleService.updateNotNull(role);
        return new Response().success(role);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public Response deleteUser(@PathVariable Long id) {
        roleService.delete(id);
        return new Response().success(id);
    }
}