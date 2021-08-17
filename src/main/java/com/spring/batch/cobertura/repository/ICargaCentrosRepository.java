package com.spring.batch.cobertura.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.cobertura.entity.CentroLogisticoTemp;

@Repository
public interface ICargaCentrosRepository extends CrudRepository<CentroLogisticoTemp, Long> {

}
