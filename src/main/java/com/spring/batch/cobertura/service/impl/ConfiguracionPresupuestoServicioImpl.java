package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.batch.cobertura.dto.ConfiguracionPresupuestoServicioDTO;
import com.spring.batch.cobertura.entity.ConfiguracionPresupuestoServicio;
import com.spring.batch.cobertura.repository.ICargaConfiguracionPresupuestoServicioRepository;
import com.spring.batch.cobertura.service.ConfiguracionPresupuestoServicioService;

@Service
public class ConfiguracionPresupuestoServicioImpl implements ConfiguracionPresupuestoServicioService {
	
	@Autowired
	private ICargaConfiguracionPresupuestoServicioRepository cargaUnidadNegPorCentroLogRepository;

	@Override
	public ConfiguracionPresupuestoServicioDTO findByCodigo(long codigo) {
		ConfiguracionPresupuestoServicioDTO configuracionPresupuestoServicioDTO = new ConfiguracionPresupuestoServicioDTO();
		try {
			ConfiguracionPresupuestoServicio configuracionPresupuestoServicio = cargaUnidadNegPorCentroLogRepository.findByCodigo(codigo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return configuracionPresupuestoServicioDTO;
	}

	@Override
	public ConfiguracionPresupuestoServicio saveConfiguracionPresupuestoServicio(ConfiguracionPresupuestoServicio configuracionPresupuestoServicio) {
		ConfiguracionPresupuestoServicio cargaUnidadNegCentroLogGuardado = new ConfiguracionPresupuestoServicio();
		try {
			cargaUnidadNegCentroLogGuardado = cargaUnidadNegPorCentroLogRepository.save(configuracionPresupuestoServicio);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaUnidadNegCentroLogGuardado;
	}
	
	
}
