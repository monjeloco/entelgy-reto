package com.entelgy.reto.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.entelgy.reto.model.response.DatoResponse;

@Component
public class EntelgyClient {

	@Value("${url.entelgy}")
	private String url;

	public ResponseEntity<List<DatoResponse>> obtenerDatos() {

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<DatoResponse>>() {
        });
	}

}
