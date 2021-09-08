package com.spring.batch.cobertura.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/* microservicio maestros*/

@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ciudad", targetEntity= CentroLogistico.class)
	private Collection<CentroLogistico> centroLogistico = new ArrayList<CentroLogistico>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<CentroLogistico> getCentroLogistico() {
		return centroLogistico;
	}

	public void setCentroLogistico(Collection<CentroLogistico> centroLogistico) {
		this.centroLogistico = centroLogistico;
	}
	
	

}