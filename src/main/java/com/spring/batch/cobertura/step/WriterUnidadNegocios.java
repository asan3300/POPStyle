package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.batch.cobertura.dto.UnidadNegocioDTO;
import com.spring.batch.cobertura.entity.UnidadNegocio;
import com.spring.batch.cobertura.service.UnidadesNegociosService;

public class WriterUnidadNegocios implements ItemWriter<List<UnidadNegocioDTO>> {

	@Autowired
	private UnidadesNegociosService unidadesNegociosService;

	@Override
	public void write(List<? extends List<UnidadNegocioDTO>> unidadesNegocios) throws Exception {
		for (List<UnidadNegocioDTO> unidadesNegociosListDTO : unidadesNegocios) {
			for (UnidadNegocioDTO unidadNegocioDTO : unidadesNegociosListDTO) {
				UnidadNegocio  unidadNegocio = new UnidadNegocio();
				unidadNegocio.setCodigoUnidad(unidadNegocioDTO.getCodigoUnidad());
				unidadNegocio.setNombreUnidad(unidadNegocioDTO.getNombreUnidad());
				unidadesNegociosService.saveUnidadesNegocios(unidadNegocio);
			}
		}
	}
}