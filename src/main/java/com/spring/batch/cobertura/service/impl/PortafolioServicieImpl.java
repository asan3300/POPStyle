package com.spring.batch.cobertura.service.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.spring.batch.cobertura.entity.CargaPortafolioTemp;
import com.spring.batch.cobertura.repository.ICargaPortafolioRepository;
import com.spring.batch.cobertura.service.PortafolioService;
import com.spring.batch.cobertura.utils.Auditoria;
import com.spring.batch.cobertura.utils.Cabecera;


@Service
public class PortafolioServicieImpl  implements PortafolioService {
	
	@Autowired
	RestTemplate restTemplate;
	 
	@Value("${url.pi}")
	private String baseUrl;

	@Value("${autenticacionPI}")
	private String plainCreds;
	
	@Autowired
	private ICargaPortafolioRepository portafolioRepository;
	
	@Override
	public String findAllWs(String fecha, String codigoCentroLogistico) {
		String portafolio = "";
		try {
			String servicio = "coberturas";
			HttpHeaders headers = Cabecera.headerPI(servicio, plainCreds);
			Auditoria auditoria = Cabecera.auditoria();
			Gson g = new Gson();
			String jsonString = g.toJson(auditoria);
			JSONObject objetoAuditoria = new JSONObject(jsonString);
			String json = "{\"auditoria\":" + objetoAuditoria
					+ ",\"parametros\":{\"servicio\":{\"centroLogistico\":{\"codigo\":\""+
					codigoCentroLogistico + "\"},\"centroBeneficio\":{\"codigo\":\"" + "\"},\"validez\":{\"fecha\":\"" + fecha + "\"}}}}";

			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, entity, String.class);
			portafolio = response.getBody();
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		return portafolio;
	}

	@Override
	public CargaPortafolioTemp saveCargaPortafolioTemp(CargaPortafolioTemp cargaPortafolioTemp) {
		CargaPortafolioTemp cargaPortafolioGuardado = new CargaPortafolioTemp();
		try {
			 cargaPortafolioGuardado = portafolioRepository.save(cargaPortafolioTemp);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaPortafolioGuardado;
	}

	@Override
	public Boolean truncateCargaPortafolioTemp() {
		Boolean borradoCorrectamente = false;
		try {
			portafolioRepository.deleteAll();
			borradoCorrectamente = true;
		} catch (Exception e) {
			System.out.println("Error: " + e);
			borradoCorrectamente = false;
		}
		return borradoCorrectamente;
	}

	@Override
	public List<Object[]> findCuentasContables() {
		List<Object[]> cuentasContable = portafolioRepository.buscarCuentasContables();
		return cuentasContable;
	}
	

	@Override
	public List<Object[]> findCentrosBeneficios() {
		List<Object[]> centrosBeneficios = portafolioRepository.buscarCentrosBeneficios();
		return centrosBeneficios;
	}

	@Override
	public List<Object[]> findTabla15() {
		List<Object[]> tabla15 = portafolioRepository.buscarTabla15();
		return tabla15;
	}

	@Override
	public List<Object[]> findServicios() {
		List<Object[]> servicios = portafolioRepository.buscarTabla15();
		return servicios;
	}

	@Override
	public List<Object[]> findUnidadesNegocios() {
		List<Object[]> unidadesNegocios = portafolioRepository.buscarTabla15();
		return unidadesNegocios;
	}

	@Override
	public List<Object[]> findCentrologCentroBen() {
		List<Object[]> centrosLogCentroLog = portafolioRepository.buscarCentrosLogCentrosBen();
		return centrosLogCentroLog;
	}

	@Override
	public List<Object[]> findUnidadNegPorCentroLog() {
		List<Object[]> unidadNegPorCentroLog = portafolioRepository.buscarCentrosLogCentrosBen();
		return unidadNegPorCentroLog;
	}
}


