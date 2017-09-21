package com.bjhxqh.mybatis.model.po;

import com.bjhxqh.common.base.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "sys_buttons")
public class SysButtons extends BaseEntity {

    private String name;

    private String event;

    private String iconclass;

    private String type;

    private Integer btnorder;

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
     * @return event
     */
    public String getEvent() {
        return event;
    }

    /**
     * @param event
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * @return iconclass
     */
    public String getIconclass() {
        return iconclass;
    }

    /**
     * @param iconclass
     */
    public void setIconclass(String iconclass) {
        this.iconclass = iconclass;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return btnorder
     */
    public Integer getBtnorder() {
        return btnorder;
    }

    /**
     * @param btnorder
     */
    public void setBtnorder(Integer btnorder) {
        this.btnorder = btnorder;
    }
}