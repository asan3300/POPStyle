package com.spring.batch.cobertura.service;

import com.spring.batch.cobertura.dto.ConfiguracionPresupuestoServicioDTO;
import com.spring.batch.cobertura.entity.ConfiguracionPresupuestoServicio;

public interface ConfiguracionPresupuestoServicioService {
	
	public ConfiguracionPresupuestoServicioDTO findByCodigo(long codigo);
	public ConfiguracionPresupuestoServicio saveConfiguracionPresupuestoServicio(ConfiguracionPresupuestoServicio configuracionPresupuestoServicio);

}
