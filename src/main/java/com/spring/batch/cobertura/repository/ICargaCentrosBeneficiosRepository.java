package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.cobertura.entity.CentroBeneficio;


@Repository
public interface ICargaCentrosBeneficiosRepository extends CrudRepository<CentroBeneficio, Long> {

	@Query("SELECT c FROM CentroBeneficio c where codigo = ?1")
	public CentroBeneficio findByCodigo(String codigo);
	
}
