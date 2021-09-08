package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.batch.cobertura.dto.Tabla15DTO;
import com.spring.batch.cobertura.entity.Tabla15;
import com.spring.batch.cobertura.service.Tabla15Service;

public class WriterTabla15 implements ItemWriter<List<Tabla15DTO>> {

	@Autowired
	private Tabla15Service tabla15Service;
	
	@Override
	public void write(List<? extends List<Tabla15DTO>> tablas15) throws Exception {
		for (List<Tabla15DTO> tablas15ListDTO : tablas15) {
			for (Tabla15DTO tabla15DTO : tablas15ListDTO) {
				Tabla15 tabla15 = new Tabla15();
				tabla15.setCodigo(tabla15DTO.getCodigo());
				tabla15.setNombre(tabla15DTO.getNombre());
				tabla15.setReportaSSF(tabla15DTO.getReportaSSF());
				tabla15Service.saveTabla15(tabla15);
			}
		}
	}

}