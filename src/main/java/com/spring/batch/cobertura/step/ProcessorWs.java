package com.spring.batch.cobertura.step;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.cobertura.entity.CargaPortafolioTemp;

public class ProcessorWs implements ItemProcessor<List<String>, List<CargaPortafolioTemp>> {
	
	private static final Logger logger = LogManager.getLogger(ProcessorWs.class);

	@Override
	public List<CargaPortafolioTemp> process(List<String> dataList) throws Exception {

		List<CargaPortafolioTemp> CargaPortafolioTempList = new ArrayList<>();
		try {
			for (String data : dataList) {
				JSONObject jsonObj = new JSONObject(data);
				JSONObject portafolio = jsonObj.getJSONObject("portafolioServicio");
				JSONArray servicios = portafolio.getJSONArray("servicios");
				if (servicios.length() > 0) {
					for (int i = 0; i < servicios.length(); i++) {
						JSONObject serviciosItem = servicios.getJSONObject(i);
						JSONArray servicio = serviciosItem.getJSONArray("servicio");
						System.out.println("Servicio -> " + servicio.toString());
						if (servicio.length() > 0) {
							for (int j = 0; j < servicio.length(); j++) {
								JSONObject servicioItem = servicio.getJSONObject(j);
								CargaPortafolioTemp CargaPortafolioTemp = new CargaPortafolioTemp();
								JSONObject centrosLogisticos = servicioItem.getJSONObject("centrosLogisticos");
								JSONObject centrosBeneficios = servicioItem.getJSONObject("centrosBeneficio");
								JSONObject centroLogistico = centrosLogisticos.getJSONObject("centroLogistico");
								CargaPortafolioTemp.setCodCentroLogistico(centroLogistico.getInt("codigo"));
								CargaPortafolioTemp.setNombreCentroLogistico(centroLogistico.getString("nombre"));
								CargaPortafolioTemp.setCodCentroBeneficio(centrosBeneficios.getString("codigo"));
								CargaPortafolioTemp.setNombreCentroBeneficio(centrosBeneficios.getString("nombre"));
								portafolioComun(servicioItem, CargaPortafolioTemp, CargaPortafolioTempList);

							}
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Error " + e);
		}

		return CargaPortafolioTempList;
	}

	private void portafolioComun(JSONObject servicio, CargaPortafolioTemp CargaPortafolioTemp,
			List<CargaPortafolioTemp> CargaPortafolioTempList) throws Exception {
			CargaPortafolioTemp.setCodServicio(servicio.getString("codigo"));
			if (servicio.get("grupoImputacion") != null) {
				Object grupoImputacion = servicio.get("grupoImputacion");
				if (grupoImputacion instanceof String) {
					CargaPortafolioTemp.setGrupoImputacion(servicio.getString("grupoImputacion"));
				} else if (grupoImputacion instanceof Integer) {
					CargaPortafolioTemp.setGrupoImputacion(servicio.getInt("grupoImputacion") + "");
				}
			}
			JSONObject tipoUso = servicio.getJSONObject("tipoUso");
			CargaPortafolioTemp.setDescripcionTipoUso(tipoUso.getString("descripcionUso"));
			if (tipoUso.get("codigoUso") != null) {
				Object codigouso = tipoUso.get("codigoUso");
				if (codigouso instanceof String) {
					CargaPortafolioTemp.setCodTipoUso(tipoUso.getString("codigoUso"));
				} else if (codigouso instanceof Integer) {
					CargaPortafolioTemp.setCodTipoUso("" + tipoUso.getInt("codigoUso"));
				}
			}
			JSONObject tipoServicio = servicio.getJSONObject("tipoServicio");
			CargaPortafolioTemp.setCodTipoServicio(tipoServicio.getString("codigoTipoServicio"));
			CargaPortafolioTemp.setDescripcionTipoServicio(tipoServicio.getString("descripcionTipoServicio"));
			JSONObject unidadNegocio = servicio.getJSONObject("unidadNegocio");
			CargaPortafolioTemp.setCodUnidadNegocio(unidadNegocio.getString("codigo"));
			CargaPortafolioTemp.setNombreUnidadNegocio(unidadNegocio.getString("nombre"));
			CargaPortafolioTemp.setNumeroParticipantes(servicio.getString("numeroParticipantes"));
			CargaPortafolioTemp.setIntensidadHorario(servicio.getString("intensidadHorario"));
			CargaPortafolioTemp.setNombreServicio(servicio.getString("nombre"));
			JSONObject line = servicio.getJSONObject("linea");
			CargaPortafolioTemp.setCodLinea(line.getString("codigo"));
			CargaPortafolioTemp.setNombreLinea(line.getString("nombre"));
			JSONObject subLinea = servicio.getJSONObject("sublinea");
			CargaPortafolioTemp.setCodSubLinea(subLinea.getString("codigo"));
			CargaPortafolioTemp.setNombreSubLinea(subLinea.getString("nombre"));
			JSONObject impuesto = servicio.getJSONObject("impuesto");
			CargaPortafolioTemp.setIndicadorImp(impuesto.getString("indicadorImp"));
			CargaPortafolioTemp.setClaseCondicion(impuesto.getString("claseCondicion"));
			
			if (impuesto.get("porcentajeImp") != null) {
				Object porcentajeImp = impuesto.get("porcentajeImp");
				if (porcentajeImp instanceof String) {
					CargaPortafolioTemp.setPorcentajeImp(impuesto.getString("porcentajeImp"));
				} else if (porcentajeImp instanceof Integer) {
					CargaPortafolioTemp.setPorcentajeImp("" + impuesto.getInt("porcentajeImp"));
				}
			}
			
			JSONObject tipoVenta = servicio.getJSONObject("tipoVenta");
			if (tipoVenta.get("codigo") != null) {
				Object codigoventa = tipoVenta.get("codigo");
				if (codigoventa instanceof String) {
					CargaPortafolioTemp.setCodTipoVenta(tipoVenta.getString("codigo"));
				} else if (codigoventa instanceof Integer) {
					CargaPortafolioTemp.setCodTipoVenta("" + tipoVenta.getInt("codigo"));
				}
			}

			CargaPortafolioTemp.setNombreTipoVenta(tipoVenta.getString("nombre"));
			JSONObject impuestos = servicio.getJSONObject("impuestos");
			CargaPortafolioTemp.setCodImpuesto(impuestos.getInt("codigo"));
			CargaPortafolioTemp.setImpuesto(impuestos.getString("impuesto"));
			
			try {
				JSONObject tabla15 = servicio.getJSONObject("tabla15");
				CargaPortafolioTemp.setCodTabla15(tabla15.getInt("codigo"));
				CargaPortafolioTemp.setReportaSSF(tabla15.getString("reportaSSF"));
				CargaPortafolioTemp.setNombreTabla15(tabla15.getString("nombre"));
			} catch (Exception e) {
				System.out.println("Sin tabla 15");
			}

			try {

				if (servicio.get("cuentasContables") instanceof JSONObject) {
					JSONObject cuentasContables = servicio.getJSONObject("cuentasContables");
					JSONObject cuentaContable = cuentasContables.getJSONObject("cuentaContable");
					CargaPortafolioTemp.setCodCuentaContable("" + cuentaContable.getLong("codigo"));
					CargaPortafolioTemp.setNombreCuentaContable(cuentaContable.getString("nombre"));
				} else if (servicio.get("cuentasContables") instanceof JSONArray) {
					JSONArray cuentasContables = servicio.getJSONArray("cuentasContables");
					if (cuentasContables.length() > 0) {
						for (int i = 0; i < cuentasContables.length(); i++) {
							JSONObject cuentasContablesItem = cuentasContables.getJSONObject(i);
							JSONObject cuentaContable = cuentasContablesItem.getJSONObject("cuentaContable");
							CargaPortafolioTemp.setCodCuentaContable("" + cuentaContable.getLong("codigo"));
							CargaPortafolioTemp.setNombreCuentaContable(cuentaContable.getString("nombre"));
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Sin cuenta contable");
			}
			
			CargaPortafolioTempList.add(CargaPortafolioTemp);
	}
}
