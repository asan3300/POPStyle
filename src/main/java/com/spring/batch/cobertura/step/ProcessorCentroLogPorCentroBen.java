package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.item.ItemProcessor;
import com.comfenalcoantioquia.coberturas.commons.dto.CentroLogCentroBen;


public class ProcessorCentroLogPorCentroBen implements ItemProcessor<List<Object[]>,  List<CentroLogCentroBen>> {

	@Override
	public List<CentroLogCentroBen> process(List<Object[]> data) throws Exception {
		List<CentroLogCentroBen> centroLogCentroBenList = new ArrayList<>();
		for (Object[] objects : data) {
			CentroLogCentroBen centroLogCentroBen = new CentroLogCentroBen();
			centroLogCentroBen.setIdCentroLogistico(Long.parseLong((objects[0]).toString()));
			centroLogCentroBen.setIdCentroBeneficio(Long.parseLong((objects[1]).toString()));
			centroLogCentroBenList.add(centroLogCentroBen); 
		}
		
		return centroLogCentroBenList;
	}
}
