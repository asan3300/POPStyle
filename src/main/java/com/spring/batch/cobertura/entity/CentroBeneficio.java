package com.spring.batch.cobertura.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/* microservicio maestros*/

@Entity
@Table(name = "centros_beneficio")
public class CentroBeneficio implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "centro_beneficio_id")
	private long id;
	
    @Column(name = "codigo")
    private String codigo;

	@Column(name = "nombre")
	private String nombre;
	
//	@ManyToOne
//	@JoinColumn(name = "centro_logistico")
//	private CentroLogistico centroLogistico;
	
//	@JsonIgnore
//    @ManyToMany(mappedBy = "centrobeneficio", cascade = CascadeType.ALL)
//	private Collection<CentroLogistico> centroLogistico = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "id_ctacontable", nullable = false)
	private CuentaContable cuentaContable;
	
	@JsonIgnore
   	@OneToMany(mappedBy = "idCentroLog", targetEntity= CentroLogCentroBen.class,fetch = FetchType.LAZY)
   	private Collection<CentroLogCentroBen> centroLogCentroBen = new ArrayList<CentroLogCentroBen>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

//	public Collection<CentroLogistico> getCentroLogistico() {
//		return centroLogistico;
//	}
//
//	public void setCentroLogistico(Collection<CentroLogistico> centroLogistico) {
//		this.centroLogistico = centroLogistico;
//	}

	public CuentaContable getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public Collection<CentroLogCentroBen> getCentroLogCentroBen() {
		return centroLogCentroBen;
	}

	public void setCentroLogCentroBen(Collection<CentroLogCentroBen> centroLogCentroBen) {
		this.centroLogCentroBen = centroLogCentroBen;
	}

}
