package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.cobertura.entity.Tabla15;

@Repository
public interface ICargaTabla15Repository extends CrudRepository<Tabla15, Long> {

	@Query("SELECT c FROM Tabla15 c where codigo = ?1")
	public Tabla15 findByCodigo(String codigo);
	
}
