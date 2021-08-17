package com.spring.batch.cobertura.utils;

public class Auditoria {

	private String idPeticion;
	private String usuario;
	private String ip;
	private String fecha;
	private String hora;
	private String operacionWeb;
	private String aplicativoPeticion;

	public String getIdPeticion() {
		return idPeticion;
	}

	public void setIdPeticion(String idPeticion) {
		this.idPeticion = idPeticion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getOperacionWeb() {
		return operacionWeb;
	}

	public void setOperacionWeb(String operacionWeb) {
		this.operacionWeb = operacionWeb;
	}

	public String getAplicativoPeticion() {
		return aplicativoPeticion;
	}

	public void setAplicativoPeticion(String aplicativoPeticion) {
		this.aplicativoPeticion = aplicativoPeticion;
	}

}
