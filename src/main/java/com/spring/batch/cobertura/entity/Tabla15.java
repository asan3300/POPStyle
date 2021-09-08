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

@Entity
@Table(name = "tabla15")
public class Tabla15 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	private String codigo;
	private String reportaSSF;
    private String nombre;


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

	public String getReportaSSF() {
		return reportaSSF;
	}

	public void setReportaSSF(String reportaSSF) {
		this.reportaSSF = reportaSSF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tabla15(long id, String codigo, String reportaSSF, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.reportaSSF = reportaSSF;
		this.nombre = nombre;
	}

	public Tabla15() {
		super();
	}

	
}