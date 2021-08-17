package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegCentroLog;
import com.spring.batch.cobertura.repository.ICargaUnidadNegPorCentroLogRepository;
import com.spring.batch.cobertura.service.UnidadNegPorCentroLogService;

@Service
public class UnidadNegPorCentroLogServiceImpl implements UnidadNegPorCentroLogService {
	
	@Autowired
	private ICargaUnidadNegPorCentroLogRepository cargaUnidadNegPorCentroLogRepository;

	@Override
	public UnidadNegCentroLog findByCodigo(long codigo) {
		UnidadNegCentroLog unidadNegCentroLog = new UnidadNegCentroLog();
		try {
			unidadNegCentroLog = cargaUnidadNegPorCentroLogRepository.findByCodigo(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return unidadNegCentroLog;
	}

	@Override
	public UnidadNegCentroLog saveUnidadNegCentroLog(UnidadNegCentroLog unidadNegCentroLog) {
		UnidadNegCentroLog cargaUnidadNegCentroLogGuardado = new UnidadNegCentroLog();
		try {
			cargaUnidadNegCentroLogGuardado = cargaUnidadNegPorCentroLogRepository.save(unidadNegCentroLog);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaUnidadNegCentroLogGuardado;
	}
	
	
}
