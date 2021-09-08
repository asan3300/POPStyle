package com.spring.batch.cobertura.dto;

public class CentroBeneficioDTO {

	private long id;
	private String codigo;
	private String nombre;
	private CuentaContableDTO cuentaContableDTO;
	//private Collection<CentroLogistico> centroLogistico = new ArrayList<>();
	
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
	public CuentaContableDTO getCuentaContableDTO() {
		return cuentaContableDTO;
	}
	public void setCuentaContableDTO(CuentaContableDTO cuentaContableDTO) {
		this.cuentaContableDTO = cuentaContableDTO;
	}
	
}
