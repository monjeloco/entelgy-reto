package com.entelgy.reto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.entelgy.reto.client.EntelgyClient;
import com.entelgy.reto.controller.RetoController;
import com.entelgy.reto.model.response.DatoResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
class RetoApplicationTests {
	
	@MockBean
    private EntelgyClient entelgyClient;
	
	@Autowired
	RetoController retoController;

	@Test
	void validarRespuestaServicio(){
		
		List<DatoResponse> datosResponse = new ArrayList<>();
		DatoResponse datoResponse1 = new DatoResponse();
		datoResponse1.setPostId(1);
		datoResponse1.setId(1);
		datoResponse1.setName("id labore ex et quam laborum");
		datoResponse1.setEmail("Eliseo@gardner.biz");
		datoResponse1.setBody("laudantium enim quasi est quidem magnam");
		
		DatoResponse datoResponse2 = new DatoResponse();
		datoResponse2.setPostId(1);
		datoResponse2.setId(2);
		datoResponse2.setName("quo vero reiciendis velit similique earum");
		datoResponse2.setEmail("Jayne_Kuhic@sydney.com");
		datoResponse2.setBody("est natus enim nihil est dolore");
		
		datosResponse.add(datoResponse1);
		datosResponse.add(datoResponse2);
		
		Mockito.when(entelgyClient.obtenerDatos()).thenReturn(ResponseEntity.ok(datosResponse));
		
		ResponseEntity<Map<String, Object>> respuesta = retoController.obtenerDatos();
		
		assertEquals("No Es igual", HttpStatus.OK, respuesta.getStatusCode());
	}

}
