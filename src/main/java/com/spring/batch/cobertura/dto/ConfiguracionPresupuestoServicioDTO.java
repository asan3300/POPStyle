package com.spring.batch.cobertura.dto;

public class ConfiguracionPresupuestoServicioDTO{

	private long id;

	private CentroLogCentroBenDTO centroLogBen;
    
	private UnidadNegocioDTO unidadNegocio;

	private ServicioDTO servicio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public CentroLogCentroBenDTO getCentroLogBen() {
		return centroLogBen;
	}

	public void setCentroLogBen(CentroLogCentroBenDTO centroLogBen) {
		this.centroLogBen = centroLogBen;
	}

	public UnidadNegocioDTO getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(UnidadNegocioDTO unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}

	public ServicioDTO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}
    

}
