package com.spring.batch.cobertura.service;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroLogistico;

public interface CentrosLogisticosService {
	
	public CentroLogistico findByCodigo(String codigo);
	public CentroLogistico saveCentrosLogisticos(CentroLogistico centroLogistico);

}
