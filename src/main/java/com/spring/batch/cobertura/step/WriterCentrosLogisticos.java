package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroLogistico;
import com.spring.batch.cobertura.service.CentrosLogisticosService;

public class WriterCentrosLogisticos implements ItemWriter<List<CentroLogistico>> {

	@Autowired
	private CentrosLogisticosService centrosLogisticosService;
	
	@Override
	public void write(List<? extends List<CentroLogistico>> centrosLogisticos) throws Exception {
		for (List<CentroLogistico> centrosLogisticos1 : centrosLogisticos) {
			for (CentroLogistico centroLogistico : centrosLogisticos1) {
				centrosLogisticosService.saveCentrosLogisticos(centroLogistico);
			}
		}
	}

}