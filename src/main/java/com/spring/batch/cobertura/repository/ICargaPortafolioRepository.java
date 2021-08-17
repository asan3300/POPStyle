package com.spring.batch.cobertura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.cobertura.entity.CargaPortafolioTemp;

@Repository
public interface ICargaPortafolioRepository extends CrudRepository<CargaPortafolioTemp, Long> {

	@Query(value = "SELECT * FROM temp_carga_portafolio", nativeQuery = true)
	List<CargaPortafolioTemp> cargaPortafolioTempList();

	@Query(value = "select distinct cod_cuenta_contable, nombre_cuenta_contable, 'A' as estado FROM public.carga_portafolio_temp where Cast(cod_cuenta_contable as BigInt) NOT IN (select codigo from public.cuentas_contables);", nativeQuery = true)
	List<Object[]> buscarCuentasContables();

	@Query(value = "select distinct t2.cod_centro_beneficio, t2.nombre_centro_beneficio, t2.cod_centro_logistico, t2.cod_cuenta_contable "
			+ "FROM public.carga_portafolio_temp t2 where cod_centro_beneficio NOT IN (select codigo from public.centros_beneficio);", nativeQuery = true)
	List<Object[]> buscarCentrosBeneficios();

	@Query(value = "select distinct t2.cod_tabla15, t2.nombre_tabla15, t2.reporta_ssf "
			+ "FROM public.carga_portafolio_temp t2 where Cast(t2.cod_tabla15 as VARCHAR) "
			+ "NOT IN (select codigo from public.tabla15)  and cod_tabla15 is not null;", nativeQuery = true)
	List<Object[]> buscarTabla15();

	@Query(value = "select distinct t2.cod_servicio, t2.nombre_servicio "
			+ "FROM public.carga_portafolio_temp t2 where t2.cod_servicio "
			+ "NOT IN (select codigo from public.servicio);", nativeQuery = true)
	List<Object[]> buscarServicios();

	@Query(value = "select distinct t2.cod_unidad_negocio, t2.nombre_unidad_negocio "
			+ "FROM public.carga_portafolio_temp t2 where t2.cod_unidad_negocio "
			+ "NOT IN (select codigo_unidad from public.unidad_negocios);", nativeQuery = true)
	List<Object[]> buscarUnidadesNegocios();
	
	@Query(value = "select t3.centro_logistico_id, t4.centro_beneficio_id "
			+ "FROM public.carga_portafolio_temp t2, public.centros_logisticos t3, public.centros_beneficio t4 "
			+ "where Cast(t2.cod_centro_logistico as VARCHAR) = t3.codigo "
			+ "and  Cast(t2.cod_centro_beneficio as VARCHAR) = t4.codigo", nativeQuery = true)
	List<Object[]> buscarCentrosLogCentrosBen();
	 
}
