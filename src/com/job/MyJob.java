package com.job;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**��Ҫִ�е�����
 * @author stormdony
 *
 */
public class MyJob implements Job{

	@Override
	//��Ҫ��ִ�е�����д��execute������
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("MyJob Start:"+new Date());
	}
	
}
