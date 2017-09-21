package com.bjhxqh.common.util;

import com.bjhxqh.common.base.quartz.BaseJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by Administrator on 2017-08-08.
 * Quartz工具类
 */
public class QuartzUtil {

    public static void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception {
        // 通过SchedulerFactory获取一个调度器实例
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        // 启动调度器
        sched.start();
        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(getClass(jobClassName).getClass()).withIdentity(jobClassName, jobGroupName).build();
        //表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
                .withSchedule(scheduleBuilder).build();
        try {
            sched.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败"+e);
            throw new Exception("创建定时任务失败");
        }
    }

    public static void jobPause(String jobClassName, String jobGroupName) throws Exception {
        // 通过SchedulerFactory获取一个调度器实例
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        sched.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    public static void jobresume(String jobClassName, String jobGroupName) throws Exception {
        // 通过SchedulerFactory获取一个调度器实例
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        sched.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    public static void jobreschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            System.out.println("更新定时任务失败"+e);
            throw new Exception("更新定时任务失败");
        }
    }

    public static void jobdelete(String jobClassName, String jobGroupName) throws Exception {
        // 通过SchedulerFactory获取一个调度器实例
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        sched.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
        sched.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
        sched.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    public static BaseJob getClass(String classname) throws Exception {
        Class<?> class1 = Class.forName(classname);
        return (BaseJob)class1.newInstance();
    }
}
