package com.spring.batch.cobertura.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.batch.cobertura.entity.CentroLogisticoTemp;
import com.spring.batch.cobertura.service.CentrosPortafolioService;
import com.spring.batch.cobertura.service.ControlPortafolioService;

public class WriterCentrosWs implements ItemWriter<List<CentroLogisticoTemp>> {
	
	@Autowired
	private CentrosPortafolioService centrosPortafolioService;

	@Override
	public void write(List<? extends List<CentroLogisticoTemp>> centroLogistico) throws Exception {
		Boolean eliminacionCorrectamente = centrosPortafolioService.truncateCentrosPortafolio();
		if (eliminacionCorrectamente) {
			for (List<CentroLogisticoTemp> portafolios : centroLogistico) {
				for (CentroLogisticoTemp portafolio : portafolios) {
					CentroLogisticoTemp guardadoCorrectamente = centrosPortafolioService.saveCentroLogisticoTemp(portafolio);
				}
			}

		}
	}
}

