package fundacionFRC.generales;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DespertarIdleDesdeIndex implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5539389665004937141L;

	/**
	 * Este método despierta el servidor idle dormido
	 * 
	 * @return valor
	 */
	public String getDespertarIdleOpenshift() {
		String valor = "";
//		try {
//
//			JobDetail job = JobBuilder.newJob(CurlJob.class).withIdentity("dummyJobName", "group1").build();
//
//			//15 CADA 15 SEGUNDOS
//			//10800 cada 3 horas
//			// Trigger the job to run on the next round minute
//			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10800).repeatForever()).build();
//
//			// schedule it
//			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//
//			if (!scheduler.checkExists(job.getKey())) {
//				scheduler.start();
//				scheduler.scheduleJob(job, trigger);
//			}
//
//		} catch (Exception e) {
//			IConstantes.log.error(e, e);
//		}

		return valor;
	}

}
