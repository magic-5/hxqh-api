package com.bjhxqh.service.impl;


import com.bjhxqh.common.base.service.ServiceSupport;
import com.bjhxqh.mybatis.model.po.SysRole;
import com.bjhxqh.mybatis.model.po.SysUser;
import com.bjhxqh.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public class SysRoleServiceImpl extends ServiceSupport<SysRole> implements SysRoleService {

    @Override
    public List<SysRole> selectByRole(SysRole role) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
//        if (StringUtil.isNotEmpty(role.getNumber())) {
//            criteria.andLike("number", "%" + role.getNumber() + "%");
//        }
        if (StringUtil.isNotEmpty(role.getName())) {
            criteria.andLike("name", "%" + role.getName() + "%");
        }
        if (role.getId() != null) {
            criteria.andEqualTo("id", role.getId());
        }
        //分页查询
        PageHelper.startPage(role.getPage(), role.getRows());
        return selectByExample(example);
    }
}
