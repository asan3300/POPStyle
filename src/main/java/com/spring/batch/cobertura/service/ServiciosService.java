package com.spring.batch.cobertura.service;

import com.spring.batch.cobertura.dto.ServicioDTO;
import com.spring.batch.cobertura.entity.Servicio;

public interface ServiciosService {
	
	public ServicioDTO findByCodigo(long codigo);
	public ServicioDTO findById(long id);
	public Servicio saveServicios(Servicio servicio);

}
