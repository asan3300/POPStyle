package com.spring.batch.cobertura.service.impl;

import java.util.ArrayList;
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
import com.spring.batch.cobertura.entity.CentroLogisticoTemp;
import com.spring.batch.cobertura.repository.ICargaCentrosRepository;
import com.spring.batch.cobertura.service.CentrosPortafolioService;
import com.spring.batch.cobertura.utils.Auditoria;
import com.spring.batch.cobertura.utils.Cabecera;

@Service
public class CentrosPortafolioServiceImpl implements CentrosPortafolioService {
	
	@Autowired
	RestTemplate restTemplate;
	 
	@Value("${url.pi}")
	private String baseUrl;

	@Value("${autenticacionPI}")
	private String plainCreds;
	
	@Autowired
	private ICargaCentrosRepository cargaCentrosRepository;

	@Override
	public String findAllWs(String fecha) {
		String portafolio = "";
		try {
			String servicio = "sedesServicio";
			HttpHeaders headers = Cabecera.headerPI(servicio, plainCreds);
			Auditoria auditoria = Cabecera.auditoria();
			Gson g = new Gson();
			String jsonString = g.toJson(auditoria);
			JSONObject objetoAuditoria = new JSONObject(jsonString);
			String json = "{\"auditoria\":" + objetoAuditoria
					+ ",\"parametros\":{\"servicio\":{\"centroLogistico\":{\"codigo\":\""
					+ "\"}}}}";

			HttpEntity<String> entity = new HttpEntity<>(json, headers);
			ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, entity, String.class);
			portafolio = response.getBody();
			System.err.println("CENTROS LOGISTICOS ->" + response.getStatusCode());
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		
		return portafolio;
	}

	@Override
	public CentroLogisticoTemp saveCentroLogisticoTemp(CentroLogisticoTemp centroLogisticoTemp) {
		CentroLogisticoTemp cargaCentrosPortafolioGuardado = new CentroLogisticoTemp();
		try {
			cargaCentrosPortafolioGuardado = cargaCentrosRepository.save(centroLogisticoTemp);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return cargaCentrosPortafolioGuardado;
	}

	@Override
	public Boolean truncateCentrosPortafolio() {
		Boolean borradoCorrectamente = false;
		try {
			cargaCentrosRepository.deleteAll();
			borradoCorrectamente = true;
		} catch (Exception e) {
			System.out.println("Error: " + e);
			borradoCorrectamente = false;
		}
		return borradoCorrectamente;
	}

	@Override
	public List<CentroLogisticoTemp> findAll() {
		List<CentroLogisticoTemp> centroLogisticoTempList = new ArrayList<CentroLogisticoTemp>();
		try {
			centroLogisticoTempList = (List<CentroLogisticoTemp>) cargaCentrosRepository.findAll();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return centroLogisticoTempList;
	}

}
