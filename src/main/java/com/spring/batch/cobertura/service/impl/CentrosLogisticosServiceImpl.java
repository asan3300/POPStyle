package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroLogistico;
import com.spring.batch.cobertura.repository.ICargaCentrosLogisticosRepository;
import com.spring.batch.cobertura.service.CentrosLogisticosService;

@Service
public class CentrosLogisticosServiceImpl implements CentrosLogisticosService {
	
	@Autowired
	private ICargaCentrosLogisticosRepository cargaCentrosLogisticosRepository;

	@Override
	public CentroLogistico findByCodigo(String codigo) {
		CentroLogistico centroLogistico = new CentroLogistico();
		try {
			centroLogistico = cargaCentrosLogisticosRepository.findByCodigo(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return centroLogistico;
	}
	
	
	@Override
	public CentroLogistico saveCentrosLogisticos(CentroLogistico centroLogistico) {
		CentroLogistico cargaCentroLogisticoGuardado = new CentroLogistico();
		try {
			cargaCentroLogisticoGuardado = cargaCentrosLogisticosRepository.save(centroLogistico);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaCentroLogisticoGuardado;
	}

}
