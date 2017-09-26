package fundacionFRC.generales;

public class CurlJob{ //implements Job {

//	/**
//	 * Ejecuta una tarea
//	 */
//	@Override
//	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//		//System.out.println("Hola mundo! - " + new java.util.Date());
//
//		try {
//			// IEmail.enviarCorreo("desde arriba, hora: " + new java.util.Date(),
//			// "openshift Quartz " + new java.util.Date(), "dannypipe@gmail.com");
//
//			leerUrl();
//
//		} catch (Exception e) {
//			IConstantes.log.error(e, e);
//		}
//
//	}
//
//	/**
//	 * Lee la url para mantener el servidor de openshift arriba. No se coloque
//	 * idle
//	 */
//	private void leerUrl() {
//
//		try {
//			URL url = new URL("http://barrigones.fundacionfrc.com/index.jsf");
//
//			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
//				for (String line; (line = reader.readLine()) != null;) {
//					// System.out.println(line);
//
//				}
//			}
//			
//			
//		} catch (Exception e) {
//			IConstantes.log.error(e, e);
//		}
//
//	}

}
