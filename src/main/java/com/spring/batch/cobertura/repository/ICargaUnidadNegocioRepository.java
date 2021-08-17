package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.comfenalcoantioquia.coberturas.commons.dto.UnidadNegocio;

@Repository
public interface ICargaUnidadNegocioRepository extends CrudRepository<UnidadNegocio, Long> {

	@Query("SELECT c FROM UnidadNegocio c where codigo = ?1")
	public UnidadNegocio findByCodigo(String codigo);
	
}
