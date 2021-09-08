package com.spring.batch.cobertura.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/* microservicio maestros*/

@Entity
@Table(name = "cuentas_contables")
public class CuentaContable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "codigo")
	private long codigo;

	@Column(name = "cuenta_contable")
	private String cuentaContable;

	@Column(name = "estado")
	private String estado;
	
    @OneToOne(mappedBy = "cuentaContable")
    @JsonIgnore
    private CentroBeneficio centroBeneficio;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCuentaContable() {
		return cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public CentroBeneficio getCentroBeneficio() {
		return centroBeneficio;
	}

	public void setCentroBeneficio(CentroBeneficio centroBeneficio) {
		this.centroBeneficio = centroBeneficio;
	}
	
	
	

}