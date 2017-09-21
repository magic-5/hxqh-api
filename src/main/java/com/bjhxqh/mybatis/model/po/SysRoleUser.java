package com.bjhxqh.mybatis.model.po;

import com.bjhxqh.common.base.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "sys_role_user")
public class SysRoleUser extends BaseEntity {

    private Integer roleid;

    private Integer userid;

    /**
     * @return roleid
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}