package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.comfenalcoantioquia.coberturas.commons.dto.CentroBeneficio;
import com.comfenalcoantioquia.coberturas.commons.dto.CuentaContable;

import com.spring.batch.cobertura.service.CuentasContablesService;

public class ProcessorCentrosBeneficio implements ItemProcessor<List<Object[]>, List<CentroBeneficio>> {


	@Autowired
	private CuentasContablesService cuentasContablesService;
	
	@Override
	public List<CentroBeneficio> process(List<Object[]> data) throws Exception {
		List<CentroBeneficio> centrosBeneficios = new ArrayList<>();
		for (Object[] objects : data) {
			CentroBeneficio centroBeneficio = new CentroBeneficio();
			System.out.println("Codigo: " + objects[2]);
			centroBeneficio.setCodigo(((String) objects[0]).toString());
			centroBeneficio.setNombre(((String) objects[1]).toString());
			String codCuentaContable = ((String) objects[1]).toString();
			Long codCuentaContableL = Long.parseLong(codCuentaContable);
			CuentaContable cuentaContable = cuentasContablesService.findByCodigo(codCuentaContableL);
			centroBeneficio.setCuentaContable(cuentaContable);
			centrosBeneficios.add(centroBeneficio);
		}

		return centrosBeneficios;
	}
}


