package com.bjhxqh.service.impl;


import com.bjhxqh.common.base.service.ServiceSupport;
import com.bjhxqh.mybatis.model.po.SysButtons;
import com.bjhxqh.mybatis.model.po.SysUser;
import com.bjhxqh.service.SysButtonsService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public class SysButtonsServiceImpl extends ServiceSupport<SysButtons> implements SysButtonsService {

    @Override
    public List<SysButtons> selectByButton(SysButtons button) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
//        if (StringUtil.isNotEmpty(button.getNumber())) {
//            criteria.andLike("number", "%" + button.getNumber() + "%");
//        }
        if (StringUtil.isNotEmpty(button.getName())) {
            criteria.andLike("name", "%" + button.getName() + "%");
        }
        if (button.getId() != null) {
            criteria.andEqualTo("id", button.getId());
        }
        //分页查询
        PageHelper.startPage(button.getPage(), button.getRows());
        return selectByExample(example);
    }
}
