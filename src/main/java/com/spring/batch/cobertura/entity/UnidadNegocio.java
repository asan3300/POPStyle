package com.spring.batch.cobertura.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/* microservicio maestros*/
@Entity
@Table(name = "unidad_negocios")
public class UnidadNegocio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad_negocio")
    private long idUnidadNegocio;

    @Column(name = "codigo_unidad")
    private String codigoUnidad;

    @Column(name = "nombre_unidad")
    private String nombreUnidad;

//    @JsonIgnore
//	@ManyToMany(mappedBy = "unidadNegocio", cascade = CascadeType.ALL)
//	private List<Usuario> usuario = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinTable(name = "unidadneg_centrolog", joinColumns = @JoinColumn(name = "id_unidadneg", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_centrolog", nullable = false))
    private List<CentroLogistico> centroLogistico = new ArrayList<>();
    
    @JsonIgnore
	@OneToMany(mappedBy = "unidadNegocio", targetEntity= ConfiguracionPresupuestoServicio.class,fetch = FetchType.LAZY)
	private Collection<ConfiguracionPresupuestoServicio> configuracionPresupuestoServ = new ArrayList<ConfiguracionPresupuestoServicio>();

    
	public long getIdUnidadNegocio() {
		return idUnidadNegocio;
	}

	public void setIdUnidadNegocio(long idUnidadNegocio) {
		this.idUnidadNegocio = idUnidadNegocio;
	}

	public String getCodigoUnidad() {
		return codigoUnidad;
	}

	public void setCodigoUnidad(String codigoUnidad) {
		this.codigoUnidad = codigoUnidad;
	}

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	public List<CentroLogistico> getCentrologistico() {
		return centroLogistico;
	}

	public void setCentrologistico(List<CentroLogistico> centroLogistico) {
		this.centroLogistico = centroLogistico;
	}

	public List<CentroLogistico> getCentroLogistico() {
		return centroLogistico;
	}

	public void setCentroLogistico(List<CentroLogistico> centroLogistico) {
		this.centroLogistico = centroLogistico;
	}

	public Collection<ConfiguracionPresupuestoServicio> getConfiguracionPresupuestoServ() {
		return configuracionPresupuestoServ;
	}

	public void setConfiguracionPresupuestoServ(Collection<ConfiguracionPresupuestoServicio> configuracionPresupuestoServ) {
		this.configuracionPresupuestoServ = configuracionPresupuestoServ;
	}
	
	
	
	
 
}
