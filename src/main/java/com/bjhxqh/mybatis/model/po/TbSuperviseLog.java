package com.bjhxqh.mybatis.model.po;

import com.bjhxqh.common.base.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_supervise_log")
public class TbSuperviseLog extends BaseEntity {

    private String projectnum;

    private String projectname;

    private Date logdate;

    private String supervisor;

    private String weather;

    private String constructionnote;

    private String jobcontent;

    /**
     * @return projectnum
     */
    public String getProjectnum() {
        return projectnum;
    }

    /**
     * @param projectnum
     */
    public void setProjectnum(String projectnum) {
        this.projectnum = projectnum;
    }

    /**
     * @return projectname
     */
    public String getProjectname() {
        return projectname;
    }

    /**
     * @param projectname
     */
    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    /**
     * @return logdate
     */
    public Date getLogdate() {
        return logdate;
    }

    /**
     * @param logdate
     */
    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    /**
     * @return supervisor
     */
    public String getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor
     */
    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return weather
     */
    public String getWeather() {
        return weather;
    }

    /**
     * @param weather
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * @return constructionnote
     */
    public String getConstructionnote() {
        return constructionnote;
    }

    /**
     * @param constructionnote
     */
    public void setConstructionnote(String constructionnote) {
        this.constructionnote = constructionnote;
    }

    /**
     * @return jobcontent
     */
    public String getJobcontent() {
        return jobcontent;
    }

    /**
     * @param jobcontent
     */
    public void setJobcontent(String jobcontent) {
        this.jobcontent = jobcontent;
    }
}