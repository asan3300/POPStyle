package com.spring.batch.cobertura.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


public class Cabecera {
	
	public static Auditoria auditoria() {
		
		Auditoria auditoria = new Auditoria();

		auditoria.setIdPeticion("coberturas");
		auditoria.setUsuario("asanchen");
		auditoria.setIp(getHostName());
		auditoria.setFecha(fecha());
		auditoria.setHora(hora());
		auditoria.setOperacionWeb("consulta");
		auditoria.setAplicativoPeticion("Coberturas");

		return auditoria;
	}

	private static String getHostName() {
		InetAddress ip;
		String hostname = null;

		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();

		} catch (UnknownHostException e) {

			e.printStackTrace();
			System.err.println("Error al obtener el hostname: " + e.getCause() + " " + e.getMessage());
		}

		return hostname;
	}

	public static String fecha() {

		return String.valueOf(LocalDate.now());
	}

	public static String hora() {

		String pattern = "HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		return simpleDateFormat.format(new Date());
	}

	public static HttpHeaders headerWizar() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	public static HttpHeaders headerPI(String servicio, String plainCreds) {
		final byte[] authBytes = plainCreds.getBytes(StandardCharsets.UTF_8);
		final String encoded = Base64.getEncoder().encodeToString(authBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Calculator_Operation", servicio);
		headers.add("Authorization", "Basic " + encoded);
		return headers;
	}

}
