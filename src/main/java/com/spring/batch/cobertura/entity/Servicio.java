package com.spring.batch.cobertura.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "servicio", targetEntity= ConfiguracionPresupuestoServicio.class,fetch = FetchType.LAZY)
	private Collection<ConfiguracionPresupuestoServicio> configuracionPresupuestoServ = new ArrayList<ConfiguracionPresupuestoServicio>();

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<ConfiguracionPresupuestoServicio> getConfiguracionPresupuestoServ() {
		return configuracionPresupuestoServ;
	}

	public void setConfiguracionPresupuestoServ(Collection<ConfiguracionPresupuestoServicio> configuracionPresupuestoServ) {
		this.configuracionPresupuestoServ = configuracionPresupuestoServ;
	}
	
	

}