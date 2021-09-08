package com.spring.batch.cobertura.service;

import com.spring.batch.cobertura.dto.CentroLogCentroBenDTO;
import com.spring.batch.cobertura.entity.CentroLogCentroBen;

public interface CentroLogCentroBenService {
	
	public CentroLogCentroBenDTO findByCodigo(long id);
	public CentroLogCentroBen saveCentroLogCentroBen(CentroLogCentroBen centroLogCentroBen);

}
