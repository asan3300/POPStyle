package com.spring.batch.cobertura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="configuracion_presupuesto_servicio")
public class ConfiguracionPresupuestoServicio implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;
	
    @ManyToOne
    @JoinColumn(name = "id_centroLogBen")
	private CentroLogCentroBen centroLogBen;
    
    @ManyToOne
    @JoinColumn(name = "id_unidadNegocio")
	private UnidadNegocio unidadNegocio;
	
	@ManyToOne
	@JoinColumn(name = "id_servicio")
	private Servicio servicio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CentroLogCentroBen getCentroLogBen() {
		return centroLogBen;
	}

	public void setCentroLogBen(CentroLogCentroBen centroLogBen) {
		this.centroLogBen = centroLogBen;
	}

	public UnidadNegocio getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(UnidadNegocio unidadNegocio) {
		this.unidadNegocio = unidadNegocio;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}


}
