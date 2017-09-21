package com.bjhxqh.common.base.quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Administrator on 2017-08-08.
 */
public interface BaseJob extends Job{
    public void execute(JobExecutionContext context) throws JobExecutionException;
}
