package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.batch.cobertura.dto.CentroBeneficioDTO;
import com.spring.batch.cobertura.dto.CuentaContableDTO;
import com.spring.batch.cobertura.entity.CentroBeneficio;
import com.spring.batch.cobertura.repository.ICargaCentrosBeneficiosRepository;
import com.spring.batch.cobertura.service.CentrosBeneficiosService;

@Service
public class CentrosBeneficiosServiceImpl implements CentrosBeneficiosService {
	
	@Autowired
	private ICargaCentrosBeneficiosRepository cargaCentrosBeneficiosRepository;

	@Override
	public CentroBeneficioDTO findByCodigo(String codigo) {
		CentroBeneficioDTO centroBeneficioDTO = new CentroBeneficioDTO();
		try {
			CentroBeneficio centroBeneficio = cargaCentrosBeneficiosRepository.findByCodigo(codigo);
			centroBeneficioDTO.setId(centroBeneficio.getId());
			centroBeneficioDTO.setCodigo(centroBeneficio.getCodigo());
			centroBeneficioDTO.setNombre(centroBeneficio.getNombre());
			CuentaContableDTO cuentaContableDTO = new CuentaContableDTO();
			cuentaContableDTO.setId(centroBeneficio.getCuentaContable().getId());
			cuentaContableDTO.setCodigo(centroBeneficio.getCuentaContable().getCodigo());
			cuentaContableDTO.setCuentaContable(centroBeneficio.getCuentaContable().getCuentaContable());
			cuentaContableDTO.setEstado(centroBeneficio.getCuentaContable().getEstado());
			centroBeneficioDTO.setCuentaContableDTO(cuentaContableDTO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return centroBeneficioDTO;
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


	@Override
	public CentroBeneficio findById(Long id) {
		CentroBeneficio centroBeneficio = new CentroBeneficio();
		try {
			 centroBeneficio = cargaCentrosBeneficiosRepository.findById(id).get();
		} catch (Exception e) {
		 System.out.print("Error " + e);
		}
		return centroBeneficio;
	}

}
