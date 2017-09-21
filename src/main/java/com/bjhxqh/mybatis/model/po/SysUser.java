package com.bjhxqh.mybatis.model.po;

import com.bjhxqh.common.base.model.BaseEntity;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user")
public class SysUser extends BaseEntity {

    private Integer departmentid;

    private String number;

    private String name;

    private String sex;

    private Date birthday;

    private String hometown;

    private String email;

    private String homephone;

    private String officephone;

    private String mobile;

    private String address;

    private String postcode;

    private String qq;

    private Integer accountid;

    /**
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
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
     * @return departmentid
     */
    public Integer getDepartmentid() {
        return departmentid;
    }

    /**
     * @param departmentid
     */
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return hometown
     */
    public String getHometown() {
        return hometown;
    }

    /**
     * @param hometown
     */
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return homephone
     */
    public String getHomephone() {
        return homephone;
    }

    /**
     * @param homephone
     */
    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    /**
     * @return officephone
     */
    public String getOfficephone() {
        return officephone;
    }

    /**
     * @param officephone
     */
    public void setOfficephone(String officephone) {
        this.officephone = officephone;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return accountid
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * @param accountid
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }
}