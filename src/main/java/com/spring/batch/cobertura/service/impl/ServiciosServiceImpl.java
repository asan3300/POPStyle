package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.batch.cobertura.dto.ServicioDTO;
import com.spring.batch.cobertura.entity.Servicio;
import com.spring.batch.cobertura.repository.ICargaServicioRepository;
import com.spring.batch.cobertura.service.ServiciosService;

@Service
public class ServiciosServiceImpl implements ServiciosService {
	
	@Autowired
	private ICargaServicioRepository cargaServicioRepository;

	@Override
	public ServicioDTO findByCodigo(long codigo) {
		ServicioDTO servicioDTO = new ServicioDTO();
		try {
			Servicio servicio = cargaServicioRepository.findByCodigo(codigo);
			servicioDTO.setId(servicio.getId());
			servicioDTO.setCodigo(Long.parseLong(servicio.getCodigo()));
			servicioDTO.setDescripcion(servicio.getDescripcion());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return servicioDTO;
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

	@Override
	public ServicioDTO findById(long id) {
		ServicioDTO servicioDTO = new ServicioDTO();
		try {
			Servicio servicio = cargaServicioRepository.findById(id).get();
			servicioDTO.setId(servicio.getId());
			servicioDTO.setCodigo(Long.parseLong(servicio.getCodigo()));
			servicioDTO.setDescripcion(servicio.getDescripcion());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return servicioDTO;
	}

}
