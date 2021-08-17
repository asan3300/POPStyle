package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comfenalcoantioquia.coberturas.commons.dto.CuentaContable;
import com.spring.batch.cobertura.repository.ICargaCuentasContablesRepository;
import com.spring.batch.cobertura.service.CuentasContablesService;

@Service
public class CuentasContablesServiceImpl implements CuentasContablesService {
	
	@Autowired
	private ICargaCuentasContablesRepository cargaCuentasContablesRepository;

	@Override
	public CuentaContable findByCodigo(long codigo) {
		CuentaContable cuentaContable = new CuentaContable();
		try {
			cuentaContable = cargaCuentasContablesRepository.findByCodigo(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cuentaContable;
	}
	
	
	@Override
	public CuentaContable saveCuentasContables(CuentaContable cuentaContable) {
		CuentaContable cargaCuentaContableGuardado = new CuentaContable();
		try {
			cargaCuentaContableGuardado = cargaCuentasContablesRepository.save(cuentaContable);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaCuentaContableGuardado;
	}

}
