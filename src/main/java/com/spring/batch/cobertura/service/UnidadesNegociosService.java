package com.spring.batch.cobertura.service;

import com.spring.batch.cobertura.dto.UnidadNegocioDTO;
import com.spring.batch.cobertura.entity.UnidadNegocio;

public interface UnidadesNegociosService {
	
	public UnidadNegocioDTO findByCodigo(Long codigo);
	public UnidadNegocioDTO findByIdv(Long id);
	public UnidadNegocio findById(Long id);
	public UnidadNegocio saveUnidadesNegocios(UnidadNegocio unidadNegocio);

}
