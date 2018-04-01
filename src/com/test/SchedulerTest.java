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
		//1.�ӹ����л�ȡ������ʵ��
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		//2.����JobDetail
		JobDetail job = JobBuilder
								.newJob(MyJob.class)
								.withIdentity("myjob", "group1")//job��name��group
								.build();
		//3.����Trigger
//		Trigger trigger=TriggerBuilder.newTrigger()
//						.withIdentity("trigger", "Tgr_group")//trigger��name��group
//						.startNow()//���ÿ���������
//						.withSchedule(// ������ȴ�������
//								SimpleScheduleBuilder
//								.repeatSecondlyForTotalCount(5, 5)//�ظ�5��,ÿ�μ��5��
//								)
//						.build();
		
		Trigger trigger=TriggerBuilder.newTrigger()
						.withIdentity("trigger", "Tgr_group")//trigger��name��group
						.startNow()//���ÿ���������
						.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
						.build();
		
		//����ҵ�ʹ�����ע�ᵽ���������
		scheduler.scheduleJob(job, trigger);
		//����������
		scheduler.start();
		
	}

}

