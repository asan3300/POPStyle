package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.batch.cobertura.dto.CentroLogisticoDTO;
import com.spring.batch.cobertura.entity.CentroLogistico;
import com.spring.batch.cobertura.entity.Ciudad;
import com.spring.batch.cobertura.service.CentrosLogisticosService;

public class WriterCentrosLogisticos implements ItemWriter<List<CentroLogisticoDTO>> {

	@Autowired
	private CentrosLogisticosService centrosLogisticosService;
	
	@Override
	public void write(List<? extends List<CentroLogisticoDTO>> centrosLogisticos) throws Exception {
		for (List<CentroLogisticoDTO> centrosLogisticosDTO : centrosLogisticos) {
			for (CentroLogisticoDTO centroLogisticoDTO : centrosLogisticosDTO) {
				CentroLogistico centroLogistico = new CentroLogistico();
				centroLogistico.setCodigo(centroLogisticoDTO.getCodigo());
				centroLogistico.setNombre(centroLogisticoDTO.getNombre());
				centroLogistico.setEstado(centroLogisticoDTO.getEstado());
				centroLogistico.setCodigoInfraestructura(centroLogisticoDTO.getCodigoInfraestructura());
				Ciudad ciudad = new Ciudad();
				ciudad.setId(centroLogisticoDTO.getCiudad().getId());
				ciudad.setDescripcion(centroLogisticoDTO.getCiudad().getDescripcion());
				centroLogistico.setCiudad(ciudad);
				centrosLogisticosService.saveCentrosLogisticos(centroLogistico);
			}
		}
	}

}