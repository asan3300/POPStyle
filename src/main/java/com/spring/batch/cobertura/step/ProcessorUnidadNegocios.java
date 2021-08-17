package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegocio;

public class ProcessorUnidadNegocios implements ItemProcessor<List<Object[]>, List<UnidadNegocio>> {

	@Override
	public List<UnidadNegocio> process(List<Object[]> data) throws Exception {
		List<UnidadNegocio> unidadesNegocios = new ArrayList<>();
		for (Object[] objects : data) {
			UnidadNegocio unidadNegocio = new UnidadNegocio();
			System.out.println("Codigo: " + objects[2]);
			unidadNegocio.setCodigoUnidad(((String) objects[0]).toString());
			unidadNegocio.setNombreUnidad(((String) objects[1]).toString());
			unidadesNegocios.add(unidadNegocio); 
		}
		
		return unidadesNegocios;
	}

}
