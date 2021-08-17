package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.comfenalcoantioquia.coberturas.commons.dto.CuentaContable;
import com.comfenalcoantioquia.coberturas.commons.dto.Tabla15;


public class ProcessorTabla15 implements ItemProcessor<List<Object[]>, List<Tabla15>> {

	@Override
	public List<Tabla15> process(List<Object[]> data) throws Exception {
		List<Tabla15> tablas15 = new ArrayList<>();
		for (Object[] objects : data) {
			Tabla15 tabla15 = new Tabla15();
			System.out.println("Codigo: " + objects[0]);
			tabla15.setCodigo(((String) objects[0]).toString());
			tabla15.setNombre(((String) objects[1]).toString());
			tabla15.setReportaSSF(((String) objects[2]).toString());
			tablas15.add(tabla15); 
		}
		
		return tablas15;
		
	}
	
}
