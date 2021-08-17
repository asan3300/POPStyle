package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comfenalcoantioquia.coberturas.commons.dto.CentroLogCentroBen;
import com.spring.batch.cobertura.repository.ICargaCentroLogCentroBenRepository;
import com.spring.batch.cobertura.service.CentroLogCentroBenService;

@Service
public class CentroLogCentroBenServiceImpl implements CentroLogCentroBenService {
	
	@Autowired
	private ICargaCentroLogCentroBenRepository cargaCentroLogCentroBenRepository;

	@Override
	public CentroLogCentroBen findByCodigo(long codigo) {
		CentroLogCentroBen centroLogCentroBen = new CentroLogCentroBen();
		try {
			centroLogCentroBen = cargaCentroLogCentroBenRepository.findByCodigo(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return centroLogCentroBen;
	}
	
	@Override
	public CentroLogCentroBen saveCentroLogCentroBen(CentroLogCentroBen centroLogCentroBen) {
		CentroLogCentroBen cargacentroLogCentroBenGuardado = new CentroLogCentroBen();
		try {
			cargacentroLogCentroBenGuardado = cargaCentroLogCentroBenRepository.save(centroLogCentroBen);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargacentroLogCentroBenGuardado;
	}

}
