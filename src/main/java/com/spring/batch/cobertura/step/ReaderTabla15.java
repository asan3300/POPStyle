package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.service.PortafolioService;


public class ReaderTabla15 implements ItemReader<List<Object[]>> {
	
	@Autowired
	private PortafolioService portafolioService;
	
	 private int readCount = 0;
	 
	@Override
	public List<Object[]> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (readCount == 1) {
			return null;
		}
		List<Object[]> tabla15 = portafolioService.findTabla15();
		readCount++;
		return tabla15;
	}
}