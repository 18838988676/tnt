package cn.com.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;

public class HelloWorldJob implements Job{
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("===================+======================");
    }
}
