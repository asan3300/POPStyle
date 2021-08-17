package com.spring.batch.cobertura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "centros_logisticos_temp")
public class CentroLogisticoTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "centro_logistico_id")
	private long idCentroLogistico;
	
	@Column(name = "codigo")
	private Integer codigoCentroLogistico;
	@Column(name = "nombre")
	private String nombreCentroLogistico;
	@Column(name = "codigo_infraestructura")
	private String codigoInfraestructura;
	
	public long getIdCentroLogistico() {
		return idCentroLogistico;
	}
	public void setIdCentroLogistico(long idCentroLogistico) {
		this.idCentroLogistico = idCentroLogistico;
	}
	public Integer getCodigoCentroLogistico() {
		return codigoCentroLogistico;
	}
	public void setCodigoCentroLogistico(Integer codigoCentroLogistico) {
		this.codigoCentroLogistico = codigoCentroLogistico;
	}
	public String getNombreCentroLogistico() {
		return nombreCentroLogistico;
	}
	public void setNombreCentroLogistico(String nombreCentroLogistico) {
		this.nombreCentroLogistico = nombreCentroLogistico;
	}
	public String getCodigoInfraestructura() {
		return codigoInfraestructura;
	}
	public void setCodigoInfraestructura(String codigoInfraestructura) {
		this.codigoInfraestructura = codigoInfraestructura;
	}
}
