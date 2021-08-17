package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroBeneficio;
import com.spring.batch.cobertura.repository.ICargaCentrosBeneficiosRepository;
import com.spring.batch.cobertura.service.CentrosBeneficiosService;

@Service
public class CentrosBeneficiosServiceImpl implements CentrosBeneficiosService {
	
	@Autowired
	private ICargaCentrosBeneficiosRepository cargaCentrosBeneficiosRepository;

	@Override
	public CentroBeneficio findByCodigo(String codigo) {
		CentroBeneficio centroBeneficio = new CentroBeneficio();
		try {
			centroBeneficio = cargaCentrosBeneficiosRepository.findByCodigo(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return centroBeneficio;
	}
	
	
	@Override
	public CentroBeneficio saveCentroBeneficio(CentroBeneficio centroBeneficio) {
		CentroBeneficio cargaCuentaContableGuardado = new CentroBeneficio();
		try {
			cargaCuentaContableGuardado = cargaCentrosBeneficiosRepository.save(centroBeneficio);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaCuentaContableGuardado;
	}

}
