package com.spring.batch.cobertura.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.batch.cobertura.dto.Tabla15DTO;
import com.spring.batch.cobertura.entity.Tabla15;
import com.spring.batch.cobertura.repository.ICargaTabla15Repository;
import com.spring.batch.cobertura.service.Tabla15Service;

@Service
public class Tabla15ServiceImpl implements Tabla15Service {
	
	@Autowired
	private ICargaTabla15Repository cargaTabla15Repository;

	@Override
	public Tabla15DTO findByCodigo(String codigo) {
		Tabla15DTO tabla15DTO = new Tabla15DTO();
		try {
			Tabla15 tabla15 = cargaTabla15Repository.findByCodigo(codigo);
			tabla15DTO.setId(tabla15.getId());
			tabla15DTO.setCodigo(tabla15.getCodigo());
			tabla15DTO.setNombre(tabla15.getNombre());
			tabla15DTO.setReportaSSF(tabla15.getReportaSSF());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tabla15DTO;
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
