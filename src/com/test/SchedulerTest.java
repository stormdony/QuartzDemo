package com.test;

import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.job.MyJob;

public class SchedulerTest {
	public static void main(String[] args) throws SchedulerException {
		//1.从工厂中获取调度器实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		//2.创建JobDetail
		JobDetail job = JobBuilder
								.newJob(MyJob.class)
								.withIdentity("myjob", "group1")//job的name和group
								.build();
		//3.创建Trigger
//		Trigger trigger=TriggerBuilder.newTrigger()
//						.withIdentity("trigger", "Tgr_group")//trigger的name和group
//						.startNow()//设置开启触发器
//						.withSchedule(// 定义调度触发规则
//								SimpleScheduleBuilder
//								.repeatSecondlyForTotalCount(5, 5)//重复5次,每次间隔5秒
//								)
//						.build();
		
		Trigger trigger=TriggerBuilder.newTrigger()
						.withIdentity("trigger", "Tgr_group")//trigger的name和group
						.startNow()//设置开启触发器
						.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
						.build();
		
		//把作业和触发器注册到任务调度中
		scheduler.scheduleJob(job, trigger);
		//☆启动调度
		scheduler.start();
		
	}

}

