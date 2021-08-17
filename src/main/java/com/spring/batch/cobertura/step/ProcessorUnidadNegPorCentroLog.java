package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;                                                                                                                  
import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegCentroLog;


public class ProcessorUnidadNegPorCentroLog implements ItemProcessor<List<Object[]>,  List<UnidadNegCentroLog>> {

	@Override
	public List<UnidadNegCentroLog> process(List<Object[]> data) throws Exception {
		List<UnidadNegCentroLog> unidadNegCentroLogList = new ArrayList<>();
		for (Object[] objects : data) {
			UnidadNegCentroLog unidadNegCentroLog = new UnidadNegCentroLog();
			unidadNegCentroLog.setIdCentroLogistico(Long.parseLong((objects[0]).toString()));
			unidadNegCentroLog.setIdUnidadNegocio(Long.parseLong((objects[1]).toString()));
			unidadNegCentroLogList.add(unidadNegCentroLog); 
		}
		
		return unidadNegCentroLogList;
	}

}
