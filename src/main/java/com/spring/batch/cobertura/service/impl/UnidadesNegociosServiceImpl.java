package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.batch.cobertura.dto.UnidadNegocioDTO;
import com.spring.batch.cobertura.entity.CentroBeneficio;
import com.spring.batch.cobertura.entity.UnidadNegocio;
import com.spring.batch.cobertura.repository.ICargaUnidadNegocioRepository;
import com.spring.batch.cobertura.service.UnidadesNegociosService;

@Service
public class UnidadesNegociosServiceImpl implements UnidadesNegociosService {
	
	@Autowired
	private ICargaUnidadNegocioRepository cargaUnidadNegocioRepository;

	@Override
	public UnidadNegocioDTO findByCodigo(Long codigo) {
		UnidadNegocioDTO unidadNegocioDTO = new UnidadNegocioDTO();
		try {
			UnidadNegocio unidadNegocio = cargaUnidadNegocioRepository.findByCodigo(codigo);
			unidadNegocioDTO.setIdUnidadNegocio(unidadNegocio.getIdUnidadNegocio());
			unidadNegocioDTO.setCodigoUnidad(unidadNegocio.getCodigoUnidad());
			unidadNegocioDTO.setNombreUnidad(unidadNegocio.getNombreUnidad());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return unidadNegocioDTO;
	}
	

	@Override
	public UnidadNegocio saveUnidadesNegocios(UnidadNegocio unidadNegocio) {
		UnidadNegocio cargaUnidadNegocioGuardado = new UnidadNegocio();
		try {
			cargaUnidadNegocioGuardado = cargaUnidadNegocioRepository.save(unidadNegocio);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaUnidadNegocioGuardado;
	}


	@Override
	public UnidadNegocio findById(Long id) {
		UnidadNegocio unidadNegocio = new UnidadNegocio();
		try {
			unidadNegocio = cargaUnidadNegocioRepository.findById(id).get();
		} catch (Exception e) {
		 System.out.print("Error " + e);
		}
		return unidadNegocio;
	}


	@Override
	public UnidadNegocioDTO findByIdv(Long id) {
		UnidadNegocioDTO unidadNegocioDTO = new UnidadNegocioDTO();
		try {
			UnidadNegocio unidadNegocio = cargaUnidadNegocioRepository.findById(id).get();
			unidadNegocioDTO.setIdUnidadNegocio(unidadNegocio.getIdUnidadNegocio());
			unidadNegocioDTO.setCodigoUnidad(unidadNegocio.getCodigoUnidad());
			unidadNegocioDTO.setNombreUnidad(unidadNegocio.getNombreUnidad());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return unidadNegocioDTO;
	}

}
