package com.spring.batch.cobertura.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
;

public class UnidadNegocioDTO {
	

	    private long idUnidadNegocio;
	    private String codigoUnidad;
	    private String nombreUnidad;
	    private List<CentroLogisticoDTO> centroLogistico = new ArrayList<>();
		
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
		public List<CentroLogisticoDTO> getCentroLogistico() {
			return centroLogistico;
		}
		public void setCentroLogistico(List<CentroLogisticoDTO> centroLogistico) {
			this.centroLogistico = centroLogistico;
		}
	    
}
