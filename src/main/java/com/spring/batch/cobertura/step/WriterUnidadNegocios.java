package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegocio;
import com.spring.batch.cobertura.service.UnidadesNegociosService;

public class WriterUnidadNegocios implements ItemWriter<List<UnidadNegocio>> {

	@Autowired
	private UnidadesNegociosService unidadesNegociosService;

	@Override
	public void write(List<? extends List<UnidadNegocio>> unidadesNegocios) throws Exception {
		for (List<UnidadNegocio> unidadesNegociosList : unidadesNegocios) {
			for (UnidadNegocio unidadNegocio : unidadesNegociosList) {
				unidadesNegociosService.saveUnidadesNegocios(unidadNegocio);
			}
		}
	}
}