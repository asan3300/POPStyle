package com.spring.batch.cobertura.service;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroLogCentroBen;

public interface CentroLogCentroBenService {
	
	public CentroLogCentroBen findByCodigo(long id);
	public CentroLogCentroBen saveCentroLogCentroBen(CentroLogCentroBen centroLogCentroBen);

}
