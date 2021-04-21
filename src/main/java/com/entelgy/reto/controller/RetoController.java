package com.entelgy.reto.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.reto.service.FormatoService;

@RestController
public class RetoController {
	
	@Autowired
	FormatoService formatoService; 

	@PostMapping(value = "/obtenerDatos")
	public ResponseEntity<Map<String, Object>> obtenerDatos(){
		Map<String, Object> valores = new HashMap<>();
		valores.put("data", formatoService.obtenerDatosFormato().toString());
		return ResponseEntity.ok(valores);

	}
}
