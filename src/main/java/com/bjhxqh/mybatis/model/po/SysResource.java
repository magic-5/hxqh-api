package com.bjhxqh.mybatis.model.po;

import com.bjhxqh.common.base.model.BaseEntity;

import javax.persistence.Table;

@Table(name = "sys_resource")
public class SysResource extends BaseEntity {

    private String name;

    private String menutype;

    private String url;

    private String method;

    private String visible;

    private Integer menuorder;

    private String menuclass;

    private Integer parent;

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
     * @return menutype
     */
    public String getMenutype() {
        return menutype;
    }

    /**
     * @param menutype
     */
    public void setMenutype(String menutype) {
        this.menutype = menutype;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return visible
     */
    public String getVisible() {
        return visible;
    }

    /**
     * @param visible
     */
    public void setVisible(String visible) {
        this.visible = visible;
    }

    /**
     * @return menuorder
     */
    public Integer getMenuorder() {
        return menuorder;
    }

    /**
     * @param menuorder
     */
    public void setMenuorder(Integer menuorder) {
        this.menuorder = menuorder;
    }

    /**
     * @return menuclass
     */
    public String getMenuclass() {
        return menuclass;
    }

    /**
     * @param menuclass
     */
    public void setMenuclass(String menuclass) {
        this.menuclass = menuclass;
    }

    /**
     * @return parent
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * @param parent
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }
}