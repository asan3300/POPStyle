package com.spring.batch.cobertura.service;

import com.spring.batch.cobertura.dto.CentroBeneficioDTO;
import com.spring.batch.cobertura.entity.CentroBeneficio;

public interface CentrosBeneficiosService {
	
	public CentroBeneficioDTO findByCodigo(String codigo);
	public CentroBeneficio findById(Long id);
	public CentroBeneficio saveCentroBeneficio(CentroBeneficio centroBeneficio);

}
