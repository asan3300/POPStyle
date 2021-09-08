package com.spring.batch.cobertura.dto;

import java.util.ArrayList;
import java.util.Collection;

public class CentroLogisticoDTO {

	private long idCentroLogistico;
	private String codigo;
	private String nombre;
	private String codigoInfraestructura;
	private String estado;

	private Collection<CentroBeneficioDTO> centrobeneficio = new ArrayList<>();
	private CiudadDTO ciudad;
	
	public long getIdCentroLogistico() {
		return idCentroLogistico;
	}
	public void setIdCentroLogistico(long idCentroLogistico) {
		this.idCentroLogistico = idCentroLogistico;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoInfraestructura() {
		return codigoInfraestructura;
	}
	public void setCodigoInfraestructura(String codigoInfraestructura) {
		this.codigoInfraestructura = codigoInfraestructura;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Collection<CentroBeneficioDTO> getCentrobeneficio() {
		return centrobeneficio;
	}
	public void setCentrobeneficio(Collection<CentroBeneficioDTO> centrobeneficio) {
		this.centrobeneficio = centrobeneficio;
	}
	public CiudadDTO getCiudad() {
		return ciudad;
	}
	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

}
