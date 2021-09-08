package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cobertura.dto.Tabla15DTO;

public class ProcessorTabla15 implements ItemProcessor<List<Object[]>, List<Tabla15DTO>> {

	@Override
	public List<Tabla15DTO> process(List<Object[]> data) throws Exception {
		List<Tabla15DTO> tablas15 = new ArrayList<>();
		for (Object[] objects : data) {
			Tabla15DTO tabla15 = new Tabla15DTO();
			System.out.println("Codigo: " + objects[0]);
			tabla15.setCodigo(((Integer) objects[0]) + "");
			tabla15.setNombre(((String) objects[1]).toString());
			tabla15.setReportaSSF(((String) objects[2]).toString());
			tablas15.add(tabla15); 
		}
		
		return tablas15;
		
	}
	
}
