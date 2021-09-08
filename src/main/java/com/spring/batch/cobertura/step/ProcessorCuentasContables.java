package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cobertura.dto.CuentaContableDTO;

public class ProcessorCuentasContables implements ItemProcessor<List<Object[]>, List<CuentaContableDTO>> {

	@Override
	public List<CuentaContableDTO> process(List<Object[]> data) throws Exception {
		List<CuentaContableDTO> cuentaContables = new ArrayList<>();
		for (Object[] objects : data) {
			CuentaContableDTO cuentaContable = new CuentaContableDTO();
			System.out.println("Codigo: " + objects[2]);
			cuentaContable.setCodigo(Long.parseLong((objects[0]).toString()));
			cuentaContable.setCuentaContable(((String) objects[1]).toString());
			cuentaContable.setEstado(((String) objects[2]).toString());
			cuentaContables.add(cuentaContable); 
		}
		
		return cuentaContables;
	}

}
