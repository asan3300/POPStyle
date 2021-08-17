package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.comfenalcoantioquia.coberturas.commons.dto.Servicio;

@Repository
public interface ICargaServicioRepository extends CrudRepository<Servicio, Long> {

	@Query("SELECT c FROM Servicio c where codigo = ?1")
	public Servicio findByCodigo(long codigo);
	
}
