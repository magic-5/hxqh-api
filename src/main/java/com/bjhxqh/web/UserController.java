package com.bjhxqh.web;


import com.bjhxqh.common.exception.Error;
import com.bjhxqh.common.exception.ResourceNotFoundException;
import com.bjhxqh.common.security.SecurityUser;
import com.bjhxqh.common.util.Constant;
import com.bjhxqh.common.util.MD5Util;
import com.bjhxqh.common.util.PaginatedResult;
import com.bjhxqh.mybatis.model.User;
import com.bjhxqh.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户详情")
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return userService
                .getUserByID(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException()
                        .setResourceName(Constant.RESOURCE_USER)
                        .setId(id));
    }

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/all/{page}")
    public ResponseEntity<?> getAllUser(@PathVariable int page) {
        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(userService.getAll(page))
                        .setCurrentPage(page)
                        .setTotalPage(userService.getTotalPage()));
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    public ResponseEntity<?> postUser(@RequestBody User user) {
        userService.addUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(user);
    }

    @ApiOperation(value = "修改用户")
    @PutMapping("/{id}")
    public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody User user) {
        assertUserExist(id);

        user.setId(id);
        userService.modifyUserById(user);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @ApiOperation(value = "修改密码")
    @PutMapping("/password")
    public ResponseEntity<?> changePassword(@RequestBody changePasswordForm form) {
        OAuth2Authentication auth = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userService.getUserByName(((SecurityUser) auth.getPrincipal()).getUsername());
        if (user.isPresent() && user.get().getPassword().equals(MD5Util.encode(form.oldPassword))) {
            User instance = user.get();
            instance.setPassword(form.newPassword);
            userService.modifyUserById(instance);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Error().setCode(500).setMessage("账户或密码错误！"));
        }
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        assertUserExist(id);

        userService.deleteUserById(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    private void assertUserExist(Long id) {
        userService
                .getUserByID(id)
                .orElseThrow(() -> new ResourceNotFoundException()
                        .setResourceName(Constant.RESOURCE_USER)
                        .setId(id));
    }

    @Data
    static class changePasswordForm {
        private String oldPassword;
        private String newPassword;
    }
}