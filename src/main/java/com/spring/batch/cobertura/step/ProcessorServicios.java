package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cobertura.dto.ServicioDTO;

public class ProcessorServicios implements ItemProcessor<List<Object[]>, List<ServicioDTO>> {

	@Override
	public List<ServicioDTO> process(List<Object[]> data) throws Exception {
		List<ServicioDTO> servicios = new ArrayList<>();
		for (Object[] objects : data) {
			ServicioDTO servicio = new ServicioDTO();
			//System.out.println("Codigo: " + objects[0]);
			servicio.setCodigo(Long.parseLong((objects[0]).toString()));
			servicio.setDescripcion(((String) objects[1]).toString());
			servicios.add(servicio); 
		}
		
		return servicios;
	}

}
