package com.spring.batch.cobertura.service;

import java.util.List;

import com.spring.batch.cobertura.entity.CentroLogisticoTemp;

public interface CentrosPortafolioService {
	
	public String findAllWs(String fecha);
	public List<CentroLogisticoTemp> findAll();
	public CentroLogisticoTemp saveCentroLogisticoTemp(CentroLogisticoTemp centroLogisticoTemp);
	public Boolean truncateCentrosPortafolio();

}
