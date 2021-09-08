package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cobertura.dto.CentroLogisticoDTO;
import com.spring.batch.cobertura.dto.CiudadDTO;
import com.spring.batch.cobertura.entity.CentroLogisticoTemp;

public class ProcessorCentrosLogisticos implements ItemProcessor<List<CentroLogisticoTemp>, List<CentroLogisticoDTO>> {

	@Override
	public List<CentroLogisticoDTO> process(List<CentroLogisticoTemp> data) throws Exception {
		List<CentroLogisticoDTO> centroLogisticosDTO = new ArrayList<>();
		for (CentroLogisticoTemp centroLogisticoTemp : data) {
			CentroLogisticoDTO centroLogisticoDTO = new CentroLogisticoDTO();
			centroLogisticoDTO.setCodigo(centroLogisticoTemp.getCodigoCentroLogistico() +"");
			centroLogisticoDTO.setCodigoInfraestructura(centroLogisticoTemp.getCodigoInfraestructura());
			centroLogisticoDTO.setEstado("A");
			centroLogisticoDTO.setNombre(centroLogisticoTemp.getNombreCentroLogistico());
			CiudadDTO  ciudadDTO = new CiudadDTO();
			ciudadDTO.setId(1);
			ciudadDTO.setDescripcion("Medellin");
			centroLogisticoDTO.setCiudad(ciudadDTO);
			centroLogisticosDTO.add(centroLogisticoDTO);
		}
		
		return centroLogisticosDTO;
	}

}
