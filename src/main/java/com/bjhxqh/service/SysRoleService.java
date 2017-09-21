package com.bjhxqh.service;


import com.bjhxqh.common.base.service.IService;
import com.bjhxqh.mybatis.model.po.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public interface SysRoleService extends IService<SysRole> {

    /**
     * 根据条件分页查询
     *
     * @param role
     * @return
     */
    List<SysRole> selectByRole(SysRole role);
}
