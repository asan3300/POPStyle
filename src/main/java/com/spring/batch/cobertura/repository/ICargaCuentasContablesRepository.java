package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comfenalcoantioquia.coberturas.commons.dto.CuentaContable;

@Repository
public interface ICargaCuentasContablesRepository extends CrudRepository<CuentaContable, Long> {

	@Query("SELECT c FROM CuentaContable c where codigo = ?1")
	public CuentaContable findByCodigo(long codigo);
	
}
