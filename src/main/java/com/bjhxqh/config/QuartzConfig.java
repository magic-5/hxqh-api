package com.bjhxqh.config;


import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017-08-08.
 */
@Configuration
public class QuartzConfig {

    @Autowired
    private DruidProperties properties;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(quartzProperties());
        return factory;
    }

    /**
     * 设置quartz属性
     * @throws IOException
     */
    public Properties quartzProperties() throws IOException {
        Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", "ServerScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.scheduler.instanceId", "NON_CLUSTERED");
        prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        prop.put("org.quartz.jobStore.isClustered", "true");
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "5");
        prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "10");
        prop.put("org.quartz.dataSource.quartzDataSource.driver", properties.getDriverClass());
        prop.put("org.quartz.dataSource.quartzDataSource.URL", properties.getUrl());
        prop.put("org.quartz.dataSource.quartzDataSource.user", properties.getUsername());
        prop.put("org.quartz.dataSource.quartzDataSource.password", properties.getPassword());
        prop.put("org.quartz.dataSource.quartzDataSource.connectionProvider.class", "com.bjhxqh.common.util.DruidConnectionProvider");
        return prop;
    }

    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }
}
