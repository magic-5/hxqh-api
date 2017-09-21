package com.bjhxqh.mybatis.model.po;

import com.bjhxqh.common.base.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "sys_department")
public class SysDepartment extends BaseEntity {

    private Integer parentid;

    private String name;

    private String departmenttype;

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
     * @return departmenttype
     */
    public String getDepartmenttype() {
        return departmenttype;
    }

    /**
     * @param departmenttype
     */
    public void setDepartmenttype(String departmenttype) {
        this.departmenttype = departmenttype;
    }
}