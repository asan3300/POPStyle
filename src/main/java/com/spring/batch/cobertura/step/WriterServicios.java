package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.batch.cobertura.dto.ServicioDTO;
import com.spring.batch.cobertura.entity.Servicio;
import com.spring.batch.cobertura.service.ServiciosService;

public class WriterServicios implements ItemWriter<List<ServicioDTO>> {

	@Autowired
	private ServiciosService serviciosService;

	@Override
	public void write(List<? extends List<ServicioDTO>> servicios) throws Exception {
		for (List<ServicioDTO> serviciosListDTO : servicios) {
			for (ServicioDTO servicioDTO : serviciosListDTO) {
				Servicio servicio = new Servicio();
				servicio.setCodigo(servicioDTO.getCodigo() + "");
				servicio.setDescripcion(servicioDTO.getDescripcion());
				serviciosService.saveServicios(servicio);
			}
		}
	}
}