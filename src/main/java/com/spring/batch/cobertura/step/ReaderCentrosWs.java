package com.spring.batch.cobertura.step;

import java.time.LocalDate;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.service.CentrosPortafolioService;

public class ReaderCentrosWs implements ItemReader<String> {
	
	@Autowired
	private CentrosPortafolioService centrosPortafolioService;
	
	private int readCount = 0;

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (readCount == 1) {
			return null;
		}
		String portafolio = "";
		LocalDate hoy = LocalDate.now();
		portafolio = centrosPortafolioService.findAllWs(hoy.toString());
		readCount++;
		return portafolio;
	}

}
