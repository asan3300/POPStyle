package com.spring.batch.cobertura.service;

import java.util.List;

import com.spring.batch.cobertura.entity.CargaPortafolioTemp;

public interface PortafolioService {
	
	public String findAllWs(String fecha, String codigoCentroLogistico);
	public List<Object[]> findCuentasContables(); 
	public List<Object[]> findCentrosBeneficios();
	public List<Object[]> findTabla15();
	public List<Object[]> findServicios();
	public List<Object[]> findUnidadesNegocios();
	public List<Object[]> findCentrologCentroBen();
	public List<Object[]> findConfiguracionPresupuestoServicio();
	public CargaPortafolioTemp saveCargaPortafolioTemp(CargaPortafolioTemp cargaPortafolioTemp);
	public Boolean truncateCargaPortafolioTemp();

}
