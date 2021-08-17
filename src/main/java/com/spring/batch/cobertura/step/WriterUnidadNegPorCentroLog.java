package com.spring.batch.cobertura.step;

import java.util.List;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegCentroLog;
import com.spring.batch.cobertura.service.UnidadNegPorCentroLogService;

public class WriterUnidadNegPorCentroLog implements ItemWriter<List<UnidadNegCentroLog>> {

	@Autowired
	private UnidadNegPorCentroLogService unidadNegPorCentroLogService;
	
	@Override
	public void write(List<? extends List<UnidadNegCentroLog>> unidadNegCentroLog) throws Exception {
		for (List<UnidadNegCentroLog> unidadNegCentroLogList : unidadNegCentroLog) {
			for (UnidadNegCentroLog unidadNegCentroLogs : unidadNegCentroLogList) {
				unidadNegPorCentroLogService.saveUnidadNegCentroLog(unidadNegCentroLogs);
			}
		}
	}

}