package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.batch.cobertura.dto.CentroLogisticoDTO;
import com.spring.batch.cobertura.dto.CiudadDTO;
import com.spring.batch.cobertura.entity.CentroBeneficio;
import com.spring.batch.cobertura.entity.CentroLogistico;
import com.spring.batch.cobertura.repository.ICargaCentrosLogisticosRepository;
import com.spring.batch.cobertura.service.CentrosLogisticosService;

@Service
public class CentrosLogisticosServiceImpl implements CentrosLogisticosService {
	
	@Autowired
	private ICargaCentrosLogisticosRepository cargaCentrosLogisticosRepository;

	@Override
	public CentroLogisticoDTO findByCodigo(String codigo) {
		CentroLogisticoDTO centroLogisticoDTO = new CentroLogisticoDTO();
		try {
			CentroLogistico centroLogistico  = cargaCentrosLogisticosRepository.findByCodigo(codigo);
			centroLogisticoDTO.setIdCentroLogistico(centroLogistico.getIdCentroLogistico());
			centroLogisticoDTO.setCodigo(centroLogistico.getCodigo());
			centroLogisticoDTO.setNombre(centroLogistico.getNombre());
			centroLogisticoDTO.setCodigoInfraestructura(centroLogistico.getCodigoInfraestructura());
			CiudadDTO ciudadDTO = new CiudadDTO();
			ciudadDTO.setId(centroLogistico.getCiudad().getId());
			ciudadDTO.setDescripcion(centroLogistico.getCiudad().getDescripcion());
			centroLogisticoDTO.setCiudad(ciudadDTO);
			centroLogisticoDTO.setEstado(centroLogistico.getEstado());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return centroLogisticoDTO;
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


	@Override
	public CentroLogistico findById(Long id) {
		CentroLogistico centroLogistico = new CentroLogistico();
		try {
			centroLogistico  = cargaCentrosLogisticosRepository.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return centroLogistico;
	}

}
