package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.cobertura.entity.CentroLogistico;


@Repository
public interface ICargaCentrosLogisticosRepository extends CrudRepository<CentroLogistico, Long> {

	@Query("SELECT c FROM CentroLogistico c where codigo = ?1")
	public CentroLogistico findByCodigo(String codigo);
	
}
