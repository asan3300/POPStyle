package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.item.ItemProcessor;
import com.comfenalcoantioquia.coberturas.commons.dto.Servicio;
public class ProcessorServicios implements ItemProcessor<List<Object[]>, List<Servicio>> {

	@Override
	public List<Servicio> process(List<Object[]> data) throws Exception {
		List<Servicio> servicios = new ArrayList<>();
		for (Object[] objects : data) {
			Servicio servicio = new Servicio();
			System.out.println("Codigo: " + objects[2]);
			servicio.setCodigo(Long.parseLong((objects[0]).toString()));
			servicio.setDescripcion(((String) objects[1]).toString());
			servicios.add(servicio); 
		}
		
		return servicios;
	}

}
