package com.spring.batch.cobertura.service;


import com.spring.batch.cobertura.dto.CuentaContableDTO;
import com.spring.batch.cobertura.entity.CuentaContable;

public interface CuentasContablesService {
	
	public CuentaContableDTO findByCodigo(long codigo);
	public CuentaContable saveCuentasContables(CuentaContable cuentaContable);

}
