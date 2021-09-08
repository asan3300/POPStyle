package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.dto.CentroLogCentroBenDTO;
import com.spring.batch.cobertura.entity.CentroBeneficio;
import com.spring.batch.cobertura.entity.CentroLogCentroBen;
import com.spring.batch.cobertura.entity.CentroLogistico;
import com.spring.batch.cobertura.service.CentroLogCentroBenService;
import com.spring.batch.cobertura.service.CentrosBeneficiosService;
import com.spring.batch.cobertura.service.CentrosLogisticosService;

public class WriterCentroLogPorCentroBen implements ItemWriter<List<CentroLogCentroBenDTO>> {

	@Autowired
	private CentroLogCentroBenService centroLogCentroBenService;
	@Autowired
	private CentrosLogisticosService centrosLogisticosService;
	@Autowired
	private CentrosBeneficiosService centrosBeneficiosService;

	@Override
	public void write(List<? extends List<CentroLogCentroBenDTO>> centroLogCentroBenList) throws Exception {
		for (List<CentroLogCentroBenDTO> centroLogCentroBenList2 : centroLogCentroBenList) {
			for (CentroLogCentroBenDTO centroLogCentroBenDTO : centroLogCentroBenList2) {
				CentroLogCentroBen centroLogCentroBen = new CentroLogCentroBen();
				CentroBeneficio centroBeneficio = centrosBeneficiosService.findById(centroLogCentroBenDTO.getIdCentroBeneficio());
				CentroLogistico centroLogistico = centrosLogisticosService.findById(centroLogCentroBenDTO.getIdCentroLogistico());
				centroLogCentroBen.setIdCentroBen(centroBeneficio);
				centroLogCentroBen.setIdCentroLog(centroLogistico);
				centroLogCentroBenService.saveCentroLogCentroBen(centroLogCentroBen);
			}
		}
	}

}