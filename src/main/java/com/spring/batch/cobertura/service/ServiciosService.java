package com.spring.batch.cobertura.service;

import com.comfenalcoantioquia.coberturas.commons.dto.Servicio;

public interface ServiciosService {
	
	public Servicio findByCodigo(long codigo);
	public Servicio saveServicios(Servicio servicio);

}
