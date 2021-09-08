package com.spring.batch.cobertura.service;

import com.spring.batch.cobertura.dto.CentroLogisticoDTO;
import com.spring.batch.cobertura.entity.CentroLogistico;

public interface CentrosLogisticosService {
	
	public CentroLogisticoDTO findByCodigo(String codigo);
	public CentroLogistico findById(Long id);
	public CentroLogistico saveCentrosLogisticos(CentroLogistico centroLogistico);

}
