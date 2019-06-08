package com.maf.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Duration;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maf.crazyhotel.domain.model.IATACode;
import com.maf.crazyhotels.app.CrazyHotelsServiceApplication;

/*
 * Note that the class is called integration test because it test the integration 
 * of the controller with the http component
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrazyHotelsServiceApplication.class)
@AutoConfigureMockMvc
public class CrazyHotelControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	/*
	 * the object mapper is needed if we want to serialize and send data with the
	 * request
	 */
	@Autowired
	private ObjectMapper objectMapper;


	@Before
	public void beforeRunningTests() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCrazyHotelsEndPointWhenFromAndToIsValid() {

		try {
			mvc.perform(get("/CrazyHotels")
					.param("from", Instant.now().toString())
					.param("to", Instant.now().minus(Duration.ofHours(5)).toString())
					.param("city",IATACode.AUE.toString())
					.param("adultsCount",new Integer(3).toString()).contentType("application/json")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCrazyHotelsEndPointWhenFromAndToIsNotValid_thenReturn400() {

		try {
			mvc.perform(get("/CrazyHotels")
					.param("from", Instant.now().toString())
					.param("to", Instant.now().plus(Duration.ofHours(5)).toString())
					.param("city",IATACode.AUE.toString())
					.param("adultsCount",new Integer(3).toString()).contentType("application/json")).andExpect(status().isBadRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
