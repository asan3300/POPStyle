package com.spring.batch.cobertura.service;

import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegocio;

public interface UnidadesNegociosService {
	
	public UnidadNegocio findByCodigo(String codigo);
	public UnidadNegocio saveUnidadesNegocios(UnidadNegocio unidadNegocio);

}
