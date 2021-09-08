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

	@Query(value = "select distinct cod_cuenta_contable, nombre_cuenta_contable, 'A' as estado FROM public.carga_portafolio_temp where Cast(cod_cuenta_contable as BigInt) "
			+ "NOT IN (select codigo from public.cuentas_contables) and cod_cuenta_contable is not null order by cod_cuenta_contable asc;", nativeQuery = true)
	List<Object[]> buscarCuentasContables();

	@Query(value = "select distinct t2.cod_centro_beneficio, t2.nombre_centro_beneficio, t2.cod_centro_logistico, t2.cod_cuenta_contable "
			+ "FROM public.carga_portafolio_temp t2 where t2.cod_centro_beneficio "
			+ "NOT IN (select codigo from public.centros_beneficio) and t2.cod_cuenta_contable is not null order by t2.cod_centro_beneficio asc;", nativeQuery = true)
	List<Object[]> buscarCentrosBeneficios();

	@Query(value = "select distinct t2.cod_tabla15, t2.nombre_tabla15, t2.reporta_ssf "
			+ "FROM public.carga_portafolio_temp t2 where Cast(t2.cod_tabla15 as VARCHAR) "
			+ "NOT IN (select codigo from public.tabla15) and cod_tabla15 is not null order by t2.cod_tabla15 asc;", nativeQuery = true)
	List<Object[]> buscarTabla15();

	@Query(value = "select distinct t2.cod_servicio, t2.nombre_servicio "
			+ "FROM public.carga_portafolio_temp t2 where t2.cod_servicio "
			+ "NOT IN (select codigo from public.servicio) order by t2.cod_servicio asc;", nativeQuery = true)
	List<Object[]> buscarServicios();

	@Query(value = "select distinct t2.cod_unidad_negocio, t2.nombre_unidad_negocio "
			+ "FROM public.carga_portafolio_temp t2 where t2.cod_unidad_negocio "
			+ "NOT IN (select codigo_unidad from public.unidad_negocios);", nativeQuery = true)
	List<Object[]> buscarUnidadesNegocios();
	
	@Query(value = "select distinct t3.centro_logistico_id, t4.centro_beneficio_id "
			+ "FROM public.carga_portafolio_temp t2, public.centros_logisticos t3, public.centros_beneficio t4 "
			+ "where Cast(t2.cod_centro_logistico as VARCHAR) = t3.codigo "
			+ "and  Cast(t2.cod_centro_beneficio as VARCHAR) = t4.codigo "
			+ "and ( t3.centro_logistico_id NOT IN (select centro_logistico_id from public.centrolog_centroben) "
			+ "or  t4.centro_beneficio_id NOT IN (select centro_beneficio_id from public.centrolog_centroben)) "
			+ "order by 1,2 asc", nativeQuery = true)
	List<Object[]> buscarCentrosLogCentrosBen();
	
	@Query(value = "select distinct t3.centro_logistico_id, t5.id, t4.id_unidad_negocio "
			+ "FROM public.carga_portafolio_temp t2, public.centros_logisticos t3, public.unidad_negocios t4, "
			+ "public.servicio t5 "
			+ "where Cast(t2.cod_centro_logistico as VARCHAR) = t3.codigo "
			+ "and  Cast(t2.cod_unidad_negocio as VARCHAR) = t4.codigo_unidad "
			+ "and  Cast(t2.cod_servicio as int) = Cast(t5.codigo as int) "
			+ "and ( t3.centro_logistico_id NOT IN (select id_centro_log_ben from public.configuracion_presupuesto_servicio) "
			+ "or  t4.id_unidad_negocio NOT IN (select id_unidad_negocio from public.configuracion_presupuesto_servicio) "
			+ "or  t5.id NOT IN (select id_servicio from public.configuracion_presupuesto_servicio)) "
			+ "order by 1,2,3 asc", nativeQuery = true)
	List<Object[]> buscarConfiguracionPresupuestoServicio();
	 
}
