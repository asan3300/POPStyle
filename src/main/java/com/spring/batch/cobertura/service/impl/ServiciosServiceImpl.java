package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comfenalcoantioquia.coberturas.commons.dto.Servicio;
import com.spring.batch.cobertura.repository.ICargaServicioRepository;
import com.spring.batch.cobertura.service.ServiciosService;

@Service
public class ServiciosServiceImpl implements ServiciosService {
	
	@Autowired
	private ICargaServicioRepository cargaServicioRepository;

	@Override
	public Servicio findByCodigo(long codigo) {
		Servicio servicio = new Servicio();
		try {
			servicio = cargaServicioRepository.findByCodigo(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return servicio;
	}
	
	@Override
	public Servicio saveServicios(Servicio servicio) {
		Servicio cargaServicioGuardado = new Servicio();
		try {
			cargaServicioGuardado = cargaServicioRepository.save(servicio);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaServicioGuardado;
	}

}
