package fundacionFRC.generales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/sinDormir")
public class LevantarServidorQuartz extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5311445582839165613L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		try {
//			
//			
//
//			JobDetail job = JobBuilder.newJob(CurlJob.class).withIdentity("dummyJobName", "group1").build();
//
//			// Trigger the job to run on the next round minute
//			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(15).repeatForever()).build();
//
//			// schedule it
//			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//			scheduler.start();
//			scheduler.scheduleJob(job, trigger);
//
//		} catch (Exception e) {
//			IConstantes.log.error(e, e);
//		}
	}

}
