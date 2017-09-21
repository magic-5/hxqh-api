package com.bjhxqh.service;


import com.bjhxqh.common.base.service.IService;
import com.bjhxqh.mybatis.model.po.SysAuthgroup;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-07-26.
 */
@Service
public interface SysAuthGroupService extends IService<SysAuthgroup> {

    /**
     * 根据条件分页查询
     *
     * @param authgroup
     * @return
     */
    List<SysAuthgroup> selectByAuthGroup(SysAuthgroup authgroup);
}
