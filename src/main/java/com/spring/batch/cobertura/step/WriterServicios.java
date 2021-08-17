package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.comfenalcoantioquia.coberturas.commons.dto.Servicio;
import com.spring.batch.cobertura.service.ServiciosService;

public class WriterServicios implements ItemWriter<List<Servicio>> {

	@Autowired
	private ServiciosService serviciosService;

	@Override
	public void write(List<? extends List<Servicio>> servicios) throws Exception {
		for (List<Servicio> serviciosList : servicios) {
			for (Servicio servicio : serviciosList) {
				serviciosService.saveServicios(servicio);
			}
		}
	}
}