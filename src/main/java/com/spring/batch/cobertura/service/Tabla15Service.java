package com.spring.batch.cobertura.service;

import com.spring.batch.cobertura.dto.Tabla15DTO;
import com.spring.batch.cobertura.entity.Tabla15;

public interface Tabla15Service {
	
	public Tabla15DTO findByCodigo(String codigo);
	public Tabla15 saveTabla15(Tabla15 tabla15);

}
