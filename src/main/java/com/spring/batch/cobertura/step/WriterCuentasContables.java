package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.dto.CuentaContableDTO;
import com.spring.batch.cobertura.entity.CuentaContable;
import com.spring.batch.cobertura.service.CuentasContablesService;

public class WriterCuentasContables implements ItemWriter<List<CuentaContableDTO>> {

	@Autowired
	private CuentasContablesService contablesService;
	
	@Override
	public void write(List<? extends List<CuentaContableDTO>> cuentaContables) throws Exception {
		for (List<CuentaContableDTO> cuentasContablesDTO : cuentaContables) {
			for (CuentaContableDTO cuentaContableDTO : cuentasContablesDTO) {
				CuentaContable cuentaContable = new CuentaContable();
				cuentaContable.setCodigo(cuentaContableDTO.getCodigo());
				cuentaContable.setCuentaContable(cuentaContableDTO.getCuentaContable());
				cuentaContable.setEstado(cuentaContableDTO.getEstado());
				contablesService.saveCuentasContables(cuentaContable);
			}
		}
	}
}


