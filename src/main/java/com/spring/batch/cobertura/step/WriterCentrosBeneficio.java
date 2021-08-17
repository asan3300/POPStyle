package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroBeneficio;
import com.spring.batch.cobertura.service.CentrosBeneficiosService;

public class WriterCentrosBeneficio implements ItemWriter<List<CentroBeneficio>> {
	
	@Autowired
	private CentrosBeneficiosService centrosBeneficiosService;

	@Override
	public void write(List<? extends List<CentroBeneficio>> centrosBeneficios) throws Exception {
		for (List<CentroBeneficio> centrosBeneficiosList : centrosBeneficios) {
			for (CentroBeneficio centroBeneficio : centrosBeneficiosList) {
				centrosBeneficiosService.saveCentroBeneficio(centroBeneficio);
			}
		}
	}

}