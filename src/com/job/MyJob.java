package com.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**需要执行的任务
 * @author stormdony
 *
 */
public class MyJob implements Job{

	@Override
	//需要在执行的任务写在execute方法内
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("MyJob Start:"+new Date());
	}
	
}
