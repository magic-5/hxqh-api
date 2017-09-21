package com.bjhxqh.mybatis.mapper;


import com.bjhxqh.mybatis.CustomMapper;
import com.bjhxqh.mybatis.model.po.SysResource;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface SysResourceMapper extends CustomMapper<SysResource> {
    ArrayList<SysResource> findResourceByUserId(String account);
    ArrayList<SysResource> findParentResource(String account);
    ArrayList<SysResource> findSecondaryMenuByUserAndParentId(@Param("account") String account, @Param("parent") int parent);
    ArrayList<SysResource> findResourceByUserAndParentId(@Param("account") String account, @Param("parent") int parent);
    ArrayList<SysResource> findAllMenu();
}