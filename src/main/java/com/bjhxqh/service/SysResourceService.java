package com.bjhxqh.service;


import com.bjhxqh.common.base.service.IService;
import com.bjhxqh.mybatis.model.po.SysResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public interface SysResourceService extends IService<SysResource> {
    //public List<MenuDto> getMenuByAccountAndParentId(String account, int parent, String parentName);
    public List<SysResource> getParentResources(String account);
    public List<SysResource> selectByResource(SysResource sysResource);
}
