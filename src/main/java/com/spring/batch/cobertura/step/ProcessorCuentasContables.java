package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import com.comfenalcoantioquia.coberturas.commons.dto.CuentaContable;

public class ProcessorCuentasContables implements ItemProcessor<List<Object[]>, List<CuentaContable>> {

	@Override
	public List<CuentaContable> process(List<Object[]> data) throws Exception {
		List<CuentaContable> cuentaContables = new ArrayList<>();
		for (Object[] objects : data) {
			CuentaContable cuentaContable = new CuentaContable();
			System.out.println("Codigo: " + objects[2]);
			cuentaContable.setCodigo(Long.parseLong((objects[0]).toString()));
			cuentaContable.setCuentaContable(((String) objects[1]).toString());
			cuentaContable.setEstado(((String) objects[2]).toString());
			cuentaContables.add(cuentaContable); 
		}
		
		return cuentaContables;
	}

}
