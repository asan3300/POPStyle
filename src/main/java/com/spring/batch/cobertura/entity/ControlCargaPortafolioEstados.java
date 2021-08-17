package com.spring.batch.cobertura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "control_carga_portafolio_estados")
public class ControlCargaPortafolioEstados {
	
	    @Id
		@Column(name = "id")
		private long id;
	    
	    @Column(name = "estado")
	    private String estado;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
	    
}
