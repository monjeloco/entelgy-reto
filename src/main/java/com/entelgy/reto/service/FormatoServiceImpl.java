package com.entelgy.reto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.entelgy.reto.client.EntelgyClient;
import com.entelgy.reto.errors.exceptions.EntelgyRetoException;
import com.entelgy.reto.model.response.DatoResponse;

@Service
public class FormatoServiceImpl implements FormatoService {

	@Autowired
	EntelgyClient entelgyClient;

	@Value("${entelgy.reto.error001.code}")
	public String codigoError001;
	@Value("${entelgy.reto.error001.mensaje}")
	public String descripcionError001;

	@Override
	public Object obtenerDatosFormato(){

		ResponseEntity<List<DatoResponse>> rptDatos = entelgyClient.obtenerDatos();

		if (!rptDatos.getStatusCode().equals(HttpStatus.OK)) {
			throw new EntelgyRetoException(codigoError001, descripcionError001);
		}

		return rptDatos.getBody();
	}

}
