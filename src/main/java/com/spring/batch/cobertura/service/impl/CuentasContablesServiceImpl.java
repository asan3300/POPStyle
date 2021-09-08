package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.batch.cobertura.dto.CuentaContableDTO;
import com.spring.batch.cobertura.entity.CuentaContable;
import com.spring.batch.cobertura.repository.ICargaCuentasContablesRepository;
import com.spring.batch.cobertura.service.CuentasContablesService;

@Service
public class CuentasContablesServiceImpl implements CuentasContablesService {
	
	@Autowired
	private ICargaCuentasContablesRepository cargaCuentasContablesRepository;

	@Override
	public CuentaContableDTO findByCodigo(long codigo) {
		CuentaContableDTO cuentaContableDTO = new CuentaContableDTO();
		try {
			CuentaContable cuentaContable = cargaCuentasContablesRepository.findByCodigo(codigo);
			cuentaContableDTO.setId(cuentaContable.getId());
			cuentaContableDTO.setCodigo(cuentaContable.getCodigo());
			cuentaContableDTO.setCuentaContable(cuentaContable.getCuentaContable());
			cuentaContableDTO.setEstado(cuentaContable.getEstado());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cuentaContableDTO;
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
