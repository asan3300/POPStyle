package com.spring.batch.cobertura.entity;

/* microservicio maestros*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "centros_logisticos")
public class CentroLogistico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "centro_logistico_id")
	private long idCentroLogistico;
	
    @Column(name = "codigo")
    private String codigo;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "codigo_infraestructura")
	private String codigoInfraestructura;
	
	@Column(name = "estado")
	private String estado;
	
	@JsonIgnore
    @ManyToMany(mappedBy = "centroLogistico", cascade = CascadeType.ALL)
	private Collection<UnidadNegocio> unidadnegocio = new ArrayList<>();
	
//    @ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
//	@JoinTable(name = "centrolog_centroben", joinColumns = @JoinColumn(name = "id_centro_log", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_centro_ben", nullable = false))
//    private Collection<CentroBeneficio> centrobeneficio = new ArrayList<>();
	
//    @JsonIgnore
//	@ManyToMany(mappedBy = "centroLogistico", cascade = CascadeType.ALL)
//	private Collection<UsuarioUnidad> usuarioUnidad = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "centroLogBen", targetEntity= ConfiguracionPresupuestoServicio.class,fetch = FetchType.LAZY)
	private Collection<ConfiguracionPresupuestoServicio> configuracionPresupuestoServ = new ArrayList<ConfiguracionPresupuestoServicio>();

	@JsonIgnore
   	@OneToMany(mappedBy = "idCentroBen", targetEntity= CentroLogCentroBen.class,fetch = FetchType.LAZY)
   	private Collection<CentroLogCentroBen> centroLogCentroBen = new ArrayList<CentroLogCentroBen>();

	@ManyToOne
	@JoinColumn(name = "ciudad")
	private Ciudad ciudad;

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

	public Collection<UnidadNegocio> getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(Collection<UnidadNegocio> unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
//
//	public Collection<CentroBeneficio> getCentrobeneficio() {
//		return centrobeneficio;
//	}
//
//	public void setCentrobeneficio(Collection<CentroBeneficio> centrobeneficio) {
//		this.centrobeneficio = centrobeneficio;
//	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Collection<CentroLogCentroBen> getCentroLogCentroBen() {
		return centroLogCentroBen;
	}

	public void setCentroLogCentroBen(Collection<CentroLogCentroBen> centroLogCentroBen) {
		this.centroLogCentroBen = centroLogCentroBen;
	}
	
	
       

}
