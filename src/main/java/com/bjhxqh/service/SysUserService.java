package com.bjhxqh.service;


import com.bjhxqh.common.base.service.IService;
import com.bjhxqh.mybatis.model.po.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public interface SysUserService extends IService<SysUser> {
    /**
     * 根据帐号account查询sysuser
     *
     * @param account
     * @return
     */
    public SysUser getUserByAccount(String account);

    /**
     * 根据条件分页查询
     *
     * @param user
     * @return
     */
    List<SysUser> selectByUser(SysUser user);
}
