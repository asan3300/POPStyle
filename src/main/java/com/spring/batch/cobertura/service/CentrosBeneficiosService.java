package com.spring.batch.cobertura.service;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroBeneficio;

public interface CentrosBeneficiosService {
	
	public CentroBeneficio findByCodigo(String codigo);
	public CentroBeneficio saveCentroBeneficio(CentroBeneficio centroBeneficio);

}
