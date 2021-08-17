package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.entity.CargaPortafolioTemp;
import com.spring.batch.cobertura.service.ControlPortafolioService;
import com.spring.batch.cobertura.service.PortafolioService;

public class WriterWs implements ItemWriter<List<CargaPortafolioTemp>> {
	
	@Autowired
	private PortafolioService portafolioService;

	@Autowired
	private ControlPortafolioService controlPortafolioService;
	
	@Override
	public void write(List<? extends List<CargaPortafolioTemp>> CargaPortafolioTemp) throws Exception {
		Boolean eliminacionCorrectamente = portafolioService.truncateCargaPortafolioTemp();
		if (eliminacionCorrectamente) {
			for (List<CargaPortafolioTemp> portafolios : CargaPortafolioTemp) {
				for (CargaPortafolioTemp portafolio : portafolios) {
					CargaPortafolioTemp guardadoCorrectamente = portafolioService.saveCargaPortafolioTemp(portafolio);
					controlPortafolioService.saveControlCargaPortafolio(guardadoCorrectamente);
					System.out.println("SE HA GUARDADO CORRECTAMENTE");

				}
			}

		}
	}
}

