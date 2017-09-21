package com.bjhxqh.mybatis.mapper;


import com.bjhxqh.mybatis.CustomMapper;
import com.bjhxqh.mybatis.model.po.SysRole;

import java.util.List;

public interface SysRoleMapper extends CustomMapper<SysRole> {

    List<SysRole> findRoleByUserId(String account);
}