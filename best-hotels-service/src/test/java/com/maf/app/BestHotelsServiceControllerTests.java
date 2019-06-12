package com.maf.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.maf.besthotels.app.BestHotelsServiceApplication;
import com.maf.besthotels.repository.IATACode;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BestHotelsServiceApplication.class)
@AutoConfigureMockMvc
public class BestHotelsServiceControllerTests {

	@Autowired
	private MockMvc mvc;

	@Before
	public void beforeRunningTests() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testBestHotelsEndPointWhenFromAndToIsValid_thenReturn200() throws Exception {

			mvc.perform(get("/BestHotels")
					.param("fromDate", LocalDate.of(2014, 02, 20).toString())
					.param("toDate", LocalDate.of(2018, 02, 20).toString())
					.param("city",IATACode.AUE.toString())
					.param("numberOfAdults",new Integer(3).toString()).contentType("application/json")).andExpect(status().isOk());
	}
	
	@Test
	public void testBestHotelsEndPointWhenFromAndToIsNotValid_thenReturn400() {

		try {
			mvc.perform(get("/BestHotels")
					.param("fromDate", LocalDate.of(2018, 02, 20).toString())
					.param("toDate", LocalDate.of(2014, 02, 20).toString())
					.param("city",IATACode.AUE.toString())
					.param("numberOfAdults",new Integer(3).toString()).contentType("application/json")).andExpect(status().isBadRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
