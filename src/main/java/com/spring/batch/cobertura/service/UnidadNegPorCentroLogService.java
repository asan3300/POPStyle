package com.spring.batch.cobertura.service;

import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegCentroLog;

public interface UnidadNegPorCentroLogService {
	
	public UnidadNegCentroLog findByCodigo(long codigo);
	public UnidadNegCentroLog saveUnidadNegCentroLog(UnidadNegCentroLog unidadNegCentroLog);

}
