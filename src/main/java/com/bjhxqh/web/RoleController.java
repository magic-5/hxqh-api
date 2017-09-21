package com.bjhxqh.web;


import com.bjhxqh.common.exception.ResourceNotFoundException;
import com.bjhxqh.common.util.Constant;
import com.bjhxqh.common.util.PaginatedResult;
import com.bjhxqh.mybatis.model.User;
import com.bjhxqh.mybatis.model.po.SysRole;
import com.bjhxqh.service.SysRoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Administrator on 2017-07-20.
 */

@RestController
public class RoleController {
    @Autowired
    private SysRoleService roleService;

    @ApiOperation(value = "获取角色列表")
    @GetMapping("/api/role")
    public ResponseEntity<?> getList(SysRole role) {
        //List<SysRole> roleList = roleService.selectByRole(role);
        //return roleList;
        return ResponseEntity
                .ok(new PageInfo<SysRole>(roleService.selectByRole(role)));
    }

    @ApiOperation(value = "获取角色详情")
    @GetMapping("/api/role/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        SysRole role = new SysRole();
        role.setId(id);
        return ResponseEntity.ok(roleService
                .selectByEntity(role));
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("/api/role")
    public ResponseEntity<?> postUser(@RequestBody SysRole role) {
        roleService.save(role);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/api/role/{id}")
                .buildAndExpand(role.getId())
                .toUri();
        return ResponseEntity
                .created(location)
                .body(role);
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("/api/role/{id}")
    public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody SysRole role) {
        role.setId(id);
        roleService.updateNotNull(role);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(role);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/api/role/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
