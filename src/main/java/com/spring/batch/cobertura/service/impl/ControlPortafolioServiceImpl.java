package com.spring.batch.cobertura.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.batch.cobertura.entity.CargaPortafolioTemp;
import com.spring.batch.cobertura.entity.ControlCargaPortafolio;
import com.spring.batch.cobertura.repository.IControlCargaPortafolioRepository;
import com.spring.batch.cobertura.service.ControlPortafolioService;

@Service
public class ControlPortafolioServiceImpl  implements ControlPortafolioService {
	
	@Autowired
	RestTemplate restTemplate;
	 
	@Autowired
	private IControlCargaPortafolioRepository controlCargaPortafolioRepository;

	@Override
	public void saveControlCargaPortafolio(CargaPortafolioTemp cargaPortafolioTemp) {
		ControlCargaPortafolio controlCargaPortafolio = new ControlCargaPortafolio();
		controlCargaPortafolio.setEstado("1");
		controlCargaPortafolio.setFechaInicio(new Date());
		controlCargaPortafolio.setIdTemp(cargaPortafolioTemp.getId());
		controlCargaPortafolioRepository.save(controlCargaPortafolio);
	}

}
