package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegCentroLog;

@Repository
public interface ICargaUnidadNegPorCentroLogRepository extends CrudRepository<UnidadNegCentroLog, Long> {

	@Query("SELECT c FROM UnidadNegCentroLog c where id = ?1")
	public UnidadNegCentroLog findByCodigo(long id);
	
}
