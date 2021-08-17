package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroLogistico;
import com.spring.batch.cobertura.entity.CentroLogisticoTemp;

public class ProcessorCentrosLogisticos implements ItemProcessor<List<CentroLogisticoTemp>, List<CentroLogistico>> {

	@Override
	public List<CentroLogistico> process(List<CentroLogisticoTemp> data) throws Exception {
		List<CentroLogistico> centroLogisticos = new ArrayList<>();
		for (CentroLogisticoTemp centroLogisticoTemp : data) {
			CentroLogistico centroLogistico = new CentroLogistico();
			centroLogistico.setCodigo(centroLogisticoTemp.getCodigoCentroLogistico() +"");
			centroLogistico.setCodigoInfraestructura(centroLogisticoTemp.getCodigoInfraestructura());
			centroLogistico.setEstado("A");
			centroLogistico.setNombre(centroLogisticoTemp.getNombreCentroLogistico());
			centroLogisticos.add(centroLogistico);
		}
		
		return centroLogisticos;
	}

}
