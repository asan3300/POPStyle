package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.comfenalcoantioquia.coberturas.commons.dto.Tabla15;
import com.spring.batch.cobertura.service.Tabla15Service;

public class WriterTabla15 implements ItemWriter<List<Tabla15>> {

	@Autowired
	private Tabla15Service tabla15Service;
	
	@Override
	public void write(List<? extends List<Tabla15>> tablas15) throws Exception {
		for (List<Tabla15> tablas15List : tablas15) {
			for (Tabla15 tabla15 : tablas15List) {
				tabla15Service.saveTabla15(tabla15);
			}
		}
	}

}