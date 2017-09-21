package com.bjhxqh.service.impl;


import com.bjhxqh.common.base.service.ServiceSupport;
import com.bjhxqh.mybatis.model.po.SysAuthgroup;
import com.bjhxqh.mybatis.model.po.SysUser;
import com.bjhxqh.service.SysAuthGroupService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public class SysAuthGroupServiceImpl extends ServiceSupport<SysAuthgroup> implements SysAuthGroupService {

    @Override
    public List<SysAuthgroup> selectByAuthGroup(SysAuthgroup authgroup) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
//        if (StringUtil.isNotEmpty(authgroup.getNumber())) {
//            criteria.andLike("number", "%" + authgroup.getNumber() + "%");
//        }
        if (StringUtil.isNotEmpty(authgroup.getName())) {
            criteria.andLike("name", "%" + authgroup.getName() + "%");
        }
        if (authgroup.getId() != null) {
            criteria.andEqualTo("id", authgroup.getId());
        }
        //分页查询
        PageHelper.startPage(authgroup.getPage(), authgroup.getRows());
        return selectByExample(example);
    }
}
