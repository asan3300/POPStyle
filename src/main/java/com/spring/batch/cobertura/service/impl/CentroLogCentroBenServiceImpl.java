package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.batch.cobertura.dto.CentroLogCentroBenDTO;
import com.spring.batch.cobertura.entity.CentroLogCentroBen;
import com.spring.batch.cobertura.repository.ICargaCentroLogCentroBenRepository;
import com.spring.batch.cobertura.service.CentroLogCentroBenService;

@Service
public class CentroLogCentroBenServiceImpl implements CentroLogCentroBenService {
	
	@Autowired
	private ICargaCentroLogCentroBenRepository cargaCentroLogCentroBenRepository;

	@Override
	public CentroLogCentroBenDTO findByCodigo(long codigo) {
		CentroLogCentroBenDTO centroLogCentroBenDTO = new CentroLogCentroBenDTO();
		try {
			CentroLogCentroBen centroLogCentroBen = cargaCentroLogCentroBenRepository.findByCodigo(codigo);
			centroLogCentroBenDTO.setId(centroLogCentroBen.getId());
			centroLogCentroBenDTO.setIdCentroBeneficio(centroLogCentroBen.getIdCentroBen().getId());
			centroLogCentroBenDTO.setIdCentroLogistico(centroLogCentroBen.getIdCentroLog().getIdCentroLogistico());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return centroLogCentroBenDTO;
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
