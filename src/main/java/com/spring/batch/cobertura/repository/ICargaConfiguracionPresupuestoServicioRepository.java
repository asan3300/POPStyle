package com.spring.batch.cobertura.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.cobertura.entity.ConfiguracionPresupuestoServicio;


@Repository
public interface ICargaConfiguracionPresupuestoServicioRepository extends CrudRepository<ConfiguracionPresupuestoServicio, Long> {

	@Query("SELECT c FROM ConfiguracionPresupuestoServicio c where id = ?1")
	public ConfiguracionPresupuestoServicio findByCodigo(long id);
	
}
