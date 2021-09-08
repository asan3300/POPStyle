package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.dto.CentroBeneficioDTO;
import com.spring.batch.cobertura.dto.CuentaContableDTO;
import com.spring.batch.cobertura.service.CuentasContablesService;

public class ProcessorCentrosBeneficio implements ItemProcessor<List<Object[]>, List<CentroBeneficioDTO>> {


	@Autowired
	private CuentasContablesService cuentasContablesService;
	
	@Override
	public List<CentroBeneficioDTO> process(List<Object[]> data) throws Exception {
		List<CentroBeneficioDTO> centrosBeneficios = new ArrayList<>();
		for (Object[] objects : data) {
			CentroBeneficioDTO centroBeneficioDTO = new CentroBeneficioDTO();
			System.out.println("Codigo: " + objects[0]);
			centroBeneficioDTO.setCodigo(((String) objects[0]).toString());
			centroBeneficioDTO.setNombre(((String) objects[1]).toString());
			String codCuentaContable = ((String) objects[3] ).toString();
			Long codCuentaContableL = Long.parseLong(codCuentaContable);
			CuentaContableDTO cuentaContableDTO = cuentasContablesService.findByCodigo(codCuentaContableL);
			centroBeneficioDTO.setCuentaContableDTO(cuentaContableDTO);
			centrosBeneficios.add(centroBeneficioDTO);
		}

		return centrosBeneficios;
	}
}


