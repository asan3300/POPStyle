package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.dto.ConfiguracionPresupuestoServicioDTO;
import com.spring.batch.cobertura.entity.CentroBeneficio;
import com.spring.batch.cobertura.entity.CentroLogCentroBen;
import com.spring.batch.cobertura.entity.ConfiguracionPresupuestoServicio;
import com.spring.batch.cobertura.entity.Servicio;
import com.spring.batch.cobertura.entity.UnidadNegocio;
import com.spring.batch.cobertura.service.CentrosBeneficiosService;
import com.spring.batch.cobertura.service.ConfiguracionPresupuestoServicioService;
import com.spring.batch.cobertura.service.UnidadesNegociosService;

public class WriterConfiguracionPresupuestoServicio implements ItemWriter<List<ConfiguracionPresupuestoServicioDTO>> {

	@Autowired
	private ConfiguracionPresupuestoServicioService configuracionPresupuestoServicioService;
	
	@Autowired
	private CentrosBeneficiosService centrosBeneficiosService;
	
	@Autowired
	private UnidadesNegociosService unidadesNegociosService;
	
	@Override
	public void write(List<? extends List<ConfiguracionPresupuestoServicioDTO>> configuracionPresupuestoServicio) throws Exception {
		for (List<ConfiguracionPresupuestoServicioDTO> ConfiguracionPresupuestoServicioDTOList : configuracionPresupuestoServicio) {
			for (ConfiguracionPresupuestoServicioDTO configuracionPresupuestoServicioDTO : ConfiguracionPresupuestoServicioDTOList) {
				ConfiguracionPresupuestoServicio configuracionPresupuestoServiciov = new ConfiguracionPresupuestoServicio();
				
				//configuracionPresupuestoServiciov.setCentroLogBen(centroLogCentroBen);
				UnidadNegocio unidadNegocio = new UnidadNegocio();
				configuracionPresupuestoServiciov.setUnidadNegocio(unidadNegocio);
				Servicio servicio = new Servicio();
				configuracionPresupuestoServiciov.setServicio(servicio);
				configuracionPresupuestoServicioService.saveConfiguracionPresupuestoServicio(configuracionPresupuestoServiciov);
			}
		}
	}

}