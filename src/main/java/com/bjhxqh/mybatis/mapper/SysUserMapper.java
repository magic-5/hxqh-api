package com.bjhxqh.mybatis.mapper;


import com.bjhxqh.mybatis.CustomMapper;
import com.bjhxqh.mybatis.model.po.SysUser;

public interface SysUserMapper extends CustomMapper<SysUser> {
    SysUser findUserbyAccount(String account);
}