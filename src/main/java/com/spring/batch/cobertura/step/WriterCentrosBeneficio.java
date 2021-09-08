package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.batch.cobertura.dto.CentroBeneficioDTO;
import com.spring.batch.cobertura.entity.CentroBeneficio;
import com.spring.batch.cobertura.entity.CuentaContable;
import com.spring.batch.cobertura.service.CentrosBeneficiosService;

public class WriterCentrosBeneficio implements ItemWriter<List<CentroBeneficioDTO>> {
	
	@Autowired
	private CentrosBeneficiosService centrosBeneficiosService;

	@Override
	public void write(List<? extends List<CentroBeneficioDTO>> centrosBeneficios) throws Exception {
		for (List<CentroBeneficioDTO> centrosBeneficiosList : centrosBeneficios) {
			for (CentroBeneficioDTO centroBeneficioDTO : centrosBeneficiosList) {
				CentroBeneficio centroBeneficio= new CentroBeneficio();
				centroBeneficio.setCodigo(centroBeneficioDTO.getCodigo());
				centroBeneficio.setNombre(centroBeneficioDTO.getNombre());
				CuentaContable cuentaContable = new CuentaContable();
				cuentaContable.setId(centroBeneficioDTO.getCuentaContableDTO().getId());
				cuentaContable.setCodigo(centroBeneficioDTO.getCuentaContableDTO().getCodigo());
				cuentaContable.setCuentaContable(centroBeneficioDTO.getCuentaContableDTO().getCuentaContable());
				cuentaContable.setEstado(centroBeneficioDTO.getCuentaContableDTO().getEstado());
				centroBeneficio.setCuentaContable(cuentaContable);
				centrosBeneficiosService.saveCentroBeneficio(centroBeneficio);
			}
		}
	}

}