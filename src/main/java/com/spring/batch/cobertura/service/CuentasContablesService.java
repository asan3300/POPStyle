package com.spring.batch.cobertura.service;

import com.comfenalcoantioquia.coberturas.commons.dto.CuentaContable;

public interface CuentasContablesService {
	
	public CuentaContable findByCodigo(long codigo);
	public CuentaContable saveCuentasContables(CuentaContable cuentaContable);

}
