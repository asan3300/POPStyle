package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cobertura.dto.CentroLogCentroBenDTO;


public class ProcessorCentroLogPorCentroBen implements ItemProcessor<List<Object[]>,  List<CentroLogCentroBenDTO>> {

	@Override
	public List<CentroLogCentroBenDTO> process(List<Object[]> data) throws Exception {
		List<CentroLogCentroBenDTO> centroLogCentroBenList = new ArrayList<>();
		for (Object[] objects : data) {
			CentroLogCentroBenDTO centroLogCentroBen = new CentroLogCentroBenDTO();
			centroLogCentroBen.setIdCentroLogistico(Long.parseLong((objects[0]).toString()));
			centroLogCentroBen.setIdCentroBeneficio(Long.parseLong((objects[1]).toString()));
			centroLogCentroBenList.add(centroLogCentroBen); 
		}
		
		return centroLogCentroBenList;
	}
}
