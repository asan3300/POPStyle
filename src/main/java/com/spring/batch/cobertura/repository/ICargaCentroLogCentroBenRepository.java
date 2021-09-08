package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.cobertura.entity.CentroLogCentroBen;

@Repository
public interface ICargaCentroLogCentroBenRepository extends CrudRepository<CentroLogCentroBen, Long> {

	@Query("SELECT c FROM CentroLogCentroBen c where id = ?1")
	public CentroLogCentroBen findByCodigo(long id);
	
}
