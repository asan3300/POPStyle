package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cobertura.dto.UnidadNegocioDTO;
public class ProcessorUnidadNegocios implements ItemProcessor<List<Object[]>, List<UnidadNegocioDTO>> {

	@Override
	public List<UnidadNegocioDTO> process(List<Object[]> data) throws Exception {
		List<UnidadNegocioDTO> unidadesNegocios = new ArrayList<>();
		for (Object[] objects : data) {
			UnidadNegocioDTO unidadNegocio = new UnidadNegocioDTO();
			System.out.println("Codigo: " + objects[0]);
			unidadNegocio.setCodigoUnidad(((String) objects[0]).toString());
			unidadNegocio.setNombreUnidad(((String) objects[1]).toString());
			unidadesNegocios.add(unidadNegocio); 
		}
		
		return unidadesNegocios;
	}

}
