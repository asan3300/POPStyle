package com.spring.batch.cobertura.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionListener extends JobExecutionListenerSupport {
	
	private static final Logger LOG = LogManager.getLogger(JobCompletionListener.class);
	
	@Value("${wsmail.remitente}")
	private String remitente;


	@Override
	public void beforeJob(JobExecution jobExecution) {
		if ((jobExecution.getStatus() == BatchStatus.STARTED)||(jobExecution.getStatus() == BatchStatus.STARTING)) {
			LOG.info("COMIENZA EL JOB ");
		}
		
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			LOG.info("FINALIZÓ EL JOB CORRECTAMENTE ");			
			//enviarEmail(" Finalizó correctamente",idbatch);
			finalizarprograma();
			System.exit(0);
		}
		
		if (jobExecution.getStatus() == BatchStatus.FAILED) {
			LOG.info("FINALIZÓ EL JOB CON ERRORES ");
			//enviarEmail(" Finalizó con errores",idbatch);
			finalizarprograma();
			System.exit(0);
		}
		
		if ((jobExecution.getStatus() == BatchStatus.STOPPED)||(jobExecution.getStatus() == BatchStatus.STOPPED)) {
			LOG.info("JOB INTERRUMPIDO ");
			//enviarEmail(" El proceso fue interrumpido",idbatch);
			finalizarprograma();
			System.exit(0);
		}
	}
	
	public void finalizarprograma(){
		  Runtime.getRuntime().addShutdownHook(new Thread() {
		    @Override
		    public void run() {
		    	LOG.info("CERRANDO JOB ");
		    }
		  } );

		}
	/*
	public void enviarEmail(String estado,Integer idbatch) {
		try {
		
			
			List<String> destinatarios = new ArrayList<String>();
			destinatarios = batchservice.getdestinatariosemail(idbatch);			
			List<String> mensajes = new ArrayList<String>();
			Map<String, Object> modelo = new HashMap<String, Object>();
			modelo.put("estado", estado);
			modelo.put("legado", Constante.nombrelegado);

			Template plantilla = freemarkerConfig.getTemplate("plantilla-email.ftl", "UTF-8");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(plantilla, modelo);
			mensajes.add(html);
			List<String> adjuntos = new ArrayList<String>();

			emailservice.enviarEmail(remitente, destinatarios, mensajes, "CargaSap-Aportes", adjuntos);

		} catch (Exception e) {
			LOG.error("Error al intentar enviar el email" + e);
		}

	}*/


}
