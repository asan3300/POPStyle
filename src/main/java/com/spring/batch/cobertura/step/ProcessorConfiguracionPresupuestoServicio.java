package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.dto.CentroLogCentroBenDTO;
import com.spring.batch.cobertura.dto.ConfiguracionPresupuestoServicioDTO;
import com.spring.batch.cobertura.dto.ServicioDTO;
import com.spring.batch.cobertura.dto.UnidadNegocioDTO;
import com.spring.batch.cobertura.service.CentroLogCentroBenService;
import com.spring.batch.cobertura.service.CentrosLogisticosService;
import com.spring.batch.cobertura.service.ServiciosService;
import com.spring.batch.cobertura.service.UnidadesNegociosService;

public class ProcessorConfiguracionPresupuestoServicio implements ItemProcessor<List<Object[]>,  List<ConfiguracionPresupuestoServicioDTO>> {

	
	@Autowired
	private CentroLogCentroBenService centroLogCentroBenService;
	
	@Autowired
	private UnidadesNegociosService unidadesNegociosService;
	
	@Autowired
	private ServiciosService serviciosService;
	
	@Override
	public List<ConfiguracionPresupuestoServicioDTO> process(List<Object[]> data) throws Exception {
		List<ConfiguracionPresupuestoServicioDTO> configuracionPresupuestoServicioDTOList = new ArrayList<>();
		for (Object[] objects : data) {
			ConfiguracionPresupuestoServicioDTO configuracionPresupuestoServicioDTO = new ConfiguracionPresupuestoServicioDTO();
			CentroLogCentroBenDTO centroLogCentroBenDTO = new CentroLogCentroBenDTO();
			centroLogCentroBenDTO = centroLogCentroBenService.findByCodigo(0);
			ServicioDTO servicioDTO = new ServicioDTO();
			servicioDTO = serviciosService.findById(0);
			UnidadNegocioDTO unidadNegocioDTO = new UnidadNegocioDTO();
			unidadNegocioDTO = unidadesNegociosService.findByIdv(null);
			configuracionPresupuestoServicioDTO.setCentroLogBen(centroLogCentroBenDTO);
			configuracionPresupuestoServicioDTO.setServicio(servicioDTO);
			configuracionPresupuestoServicioDTO.setUnidadNegocio(unidadNegocioDTO);
			configuracionPresupuestoServicioDTOList.add(configuracionPresupuestoServicioDTO); 
		}
		
		return configuracionPresupuestoServicioDTOList;
	}

}
