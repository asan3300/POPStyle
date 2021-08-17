package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cobertura.entity.CentroLogisticoTemp;


public class ProcessorCentrosWs implements ItemProcessor<String, List<CentroLogisticoTemp>> {
	
	private static final Logger logger = LogManager.getLogger(ProcessorCentrosWs.class);

	@Override
	public List<CentroLogisticoTemp> process(String data) throws Exception {
	
		List<CentroLogisticoTemp> centroLogisticoList = new ArrayList<>();
		try {
		
			JSONObject jsonObj = new JSONObject(data);
			JSONArray centroLogisticos = jsonObj.getJSONArray("centroLogisticos");
			if (centroLogisticos.length() > 0) {
				for (int i = 0; i < centroLogisticos.length(); i++) {
					CentroLogisticoTemp centroLogisticoTemp = new CentroLogisticoTemp();
					JSONObject centroLogisticosItem = centroLogisticos.getJSONObject(i);
					JSONObject centroLogistico = centroLogisticosItem.getJSONObject("centroLogistico");
					System.out.println("centroLogistico -> " + centroLogistico.toString());
					centroLogisticoTemp.setCodigoCentroLogistico(centroLogistico.getInt("codigoCentroLogistico"));
					centroLogisticoTemp.setNombreCentroLogistico(centroLogistico.getString("nombreCentroLogistico"));
					JSONObject centroInfraestructura = centroLogisticosItem.getJSONObject("centroInfraestructura");
					System.out.println("centroInfraestructura -> " + centroInfraestructura.toString());
					centroLogisticoTemp.setCodigoInfraestructura(centroInfraestructura.getString("codigoInfraestructura"));
					centroLogisticoList.add(centroLogisticoTemp);
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error " + e);
		}

		return centroLogisticoList;
	}
}
