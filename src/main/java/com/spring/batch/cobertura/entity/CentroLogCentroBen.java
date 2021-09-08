package com.spring.batch.cobertura.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/* microservicio maestros*/

@Entity
@Table(name="centrolog_centroben")
public class CentroLogCentroBen implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;
    
    @JsonIgnore
   	@OneToMany(mappedBy = "centroLogBen", targetEntity= ConfiguracionPresupuestoServicio.class,fetch = FetchType.LAZY)
   	private Collection<ConfiguracionPresupuestoServicio> configuracionPresupuestoServ = new ArrayList<ConfiguracionPresupuestoServicio>();

    @ManyToOne
    @JoinColumn(name = "centro_logistico_id")
	private CentroLogistico idCentroLog;
	
	@ManyToOne
	@JoinColumn(name = "centro_beneficio_id")
	private CentroBeneficio idCentroBen;
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<ConfiguracionPresupuestoServicio> getConfiguracionPresupuestoServ() {
		return configuracionPresupuestoServ;
	}

	public void setConfiguracionPresupuestoServ(Collection<ConfiguracionPresupuestoServicio> configuracionPresupuestoServ) {
		this.configuracionPresupuestoServ = configuracionPresupuestoServ;
	}

	public CentroLogistico getIdCentroLog() {
		return idCentroLog;
	}

	public void setIdCentroLog(CentroLogistico idCentroLog) {
		this.idCentroLog = idCentroLog;
	}

	public CentroBeneficio getIdCentroBen() {
		return idCentroBen;
	}

	public void setIdCentroBen(CentroBeneficio idCentroBen) {
		this.idCentroBen = idCentroBen;
	}
	
	
	
	

}
