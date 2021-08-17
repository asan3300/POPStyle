package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.comfenalcoantioquia.coberturas.commons.dto.CuentaContable;
import com.spring.batch.cobertura.service.CuentasContablesService;

public class WriterCuentasContables implements ItemWriter<List<CuentaContable>> {

	@Autowired
	private CuentasContablesService contablesService;
	
	@Override
	public void write(List<? extends List<CuentaContable>> cuentaContables) throws Exception {
		for (List<CuentaContable> cuentasContables : cuentaContables) {
			for (CuentaContable cuentaContable : cuentasContables) {
				contablesService.saveCuentasContables(cuentaContable);
			}
		}
	}
}


