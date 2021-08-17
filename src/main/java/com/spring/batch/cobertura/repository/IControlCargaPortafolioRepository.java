package com.spring.batch.cobertura.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.cobertura.entity.ControlCargaPortafolio;

@Repository
public interface IControlCargaPortafolioRepository extends CrudRepository<ControlCargaPortafolio, Long> {

}
