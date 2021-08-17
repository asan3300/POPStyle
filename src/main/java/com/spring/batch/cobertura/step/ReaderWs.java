package com.spring.batch.cobertura.step;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.entity.CargaPortafolioTemp;
import com.spring.batch.cobertura.entity.CentroLogisticoTemp;
import com.spring.batch.cobertura.service.CentrosPortafolioService;
import com.spring.batch.cobertura.service.PortafolioService;


public class ReaderWs implements ItemReader<List<String>> {
	
	private int readCount = 0;
	
	@Autowired
	private PortafolioService portafolioService;
	
	@Autowired
	private CentrosPortafolioService centrosPortafolioService;
	
	@Override
	public List<String> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (readCount == 1) {
			return null;
		}
		List<String> portafolio = new ArrayList<String>();
		LocalDate hoy = LocalDate.now();
		List<CentroLogisticoTemp> centroLogisticoTempList = centrosPortafolioService.findAll();
		for (CentroLogisticoTemp centroLogisticoTemp : centroLogisticoTempList) {
			String cargaPortafolioTemp = portafolioService.findAllWs(hoy.toString(), centroLogisticoTemp.getCodigoCentroLogistico()+"");
			portafolio.add(cargaPortafolioTemp);
		}
		readCount++;
		return portafolio;
	}
	

}