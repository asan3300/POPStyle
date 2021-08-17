package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comfenalcoantioquia.coberturas.commons.dto.CuentaContable;
import com.comfenalcoantioquia.coberturas.commons.dto.Tabla15;
import com.spring.batch.cobertura.repository.ICargaCuentasContablesRepository;
import com.spring.batch.cobertura.repository.ICargaTabla15Repository;
import com.spring.batch.cobertura.service.CuentasContablesService;
import com.spring.batch.cobertura.service.Tabla15Service;

@Service
public class Tabla15ServiceImpl implements Tabla15Service {
	
	@Autowired
	private ICargaTabla15Repository cargaTabla15Repository;

	@Override
	public Tabla15 findByCodigo(String codigo) {
		Tabla15 tabla15 = new Tabla15();
		try {
			tabla15 = cargaTabla15Repository.findByCodigo(codigo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tabla15;
	}
	
	@Override
	public Tabla15 saveTabla15(Tabla15 tabla15) {
		Tabla15 cargaTabla15Guardado = new Tabla15();
		try {
			cargaTabla15Guardado = cargaTabla15Repository.save(tabla15);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaTabla15Guardado;
	}

}
