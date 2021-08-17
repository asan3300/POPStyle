package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.entity.CentroLogisticoTemp;
import com.spring.batch.cobertura.service.CentrosPortafolioService;


public class ReaderCentrosLogisticos implements ItemReader<List<CentroLogisticoTemp>> {
	
	@Autowired
	private CentrosPortafolioService centrosPortafolioService;
	
	 private int readCount = 0;
	 
	
	@Override
	public List<CentroLogisticoTemp> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (readCount == 1) {
			return null;
		}
		List<CentroLogisticoTemp> centrosLogisticos = centrosPortafolioService.findAll();
		readCount++;
		return centrosLogisticos;
	}
}