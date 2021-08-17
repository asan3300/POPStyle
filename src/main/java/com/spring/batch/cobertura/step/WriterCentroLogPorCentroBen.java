package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.comfenalcoantioquia.coberturas.commons.dto.CentroLogCentroBen;
import com.spring.batch.cobertura.service.CentroLogCentroBenService;

public class WriterCentroLogPorCentroBen implements ItemWriter<List<CentroLogCentroBen>> {

	@Autowired
	private CentroLogCentroBenService centroLogCentroBenService;

	@Override
	public void write(List<? extends List<CentroLogCentroBen>> centroLogCentroBenList) throws Exception {
		for (List<CentroLogCentroBen> centroLogCentroBenList2 : centroLogCentroBenList) {
			for (CentroLogCentroBen centroLogCentroBen : centroLogCentroBenList2) {
				centroLogCentroBenService.saveCentroLogCentroBen(centroLogCentroBen);
			}
		}
	}

}