package com.bjhxqh.mybatis.model.po;

import com.bjhxqh.common.base.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "sys_authgroup_resource")
public class SysAuthgroupResource extends BaseEntity {

    private Integer groupid;

    private Integer resourceid;

    /**
     * @return groupid
     */
    public Integer getGroupid() {
        return groupid;
    }

    /**
     * @param groupid
     */
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    /**
     * @return resourceid
     */
    public Integer getResourceid() {
        return resourceid;
    }

    /**
     * @param resourceid
     */
    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }
}