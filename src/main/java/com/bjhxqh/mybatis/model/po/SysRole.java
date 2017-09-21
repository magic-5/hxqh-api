package com.bjhxqh.mybatis.model.po;

import com.bjhxqh.common.base.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "sys_role")
public class SysRole extends BaseEntity {

    private Integer parentid;

    private String name;

    private String roletype;

    /**
     * @return parentid
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return roletype
     */
    public String getRoletype() {
        return roletype;
    }

    /**
     * @param roletype
     */
    public void setRoletype(String roletype) {
        this.roletype = roletype;
    }
}