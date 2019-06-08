package com.maf.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maf.crazyhotel.domain.model.CrazyHotel;
import com.maf.crazyhotel.domain.model.IATACode;
import com.maf.crazyhotels.app.CrazyHotelsServiceApplication;
import com.maf.crazyhotels.controller.CrazyHotelsController;
import com.maf.crazyhotels.service.CrazyHotelService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrazyHotelsServiceApplication.class)
@AutoConfigureMockMvc
public class CrazyHotelControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CrazyHotelService crazyHotelService;

	@InjectMocks
	private CrazyHotelsController crazyHotelServiceController;

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
	public void testCrazyHotelEndPointGivenValidParams_ThenReturnDataFromService() throws Exception {

		given(crazyHotelService.retriveAllCrazyHotels(Instant.now(), Instant.now().minus(Duration.ofHours(5)),
				IATACode.AUE, new Integer(3))).willReturn(new HashMap<Integer, CrazyHotel>() {
					{
						put(1, new CrazyHotel(1, "Starwood", "***", 150.469, "10%",
								Arrays.asList("Jackozi", "Envelopes", "LED Monitor")));
						put(2, new CrazyHotel(2, "Marriott", "****", 250.605, "0%",
								Arrays.asList("Table Lamp", "King Size Bed")));
						put(3, new CrazyHotel(3, "Lime Wood", "**", 180.0, "0%",
								Arrays.asList("Large Swimming pool", "Air Conditions")));
					}
				}.values());

	    MockHttpServletResponse response=   mvc.perform(get("/CrazyHotels").param("from", Instant.now().toString())
				.param("to", Instant.now().minus(Duration.ofHours(5)).toString()).param("city", IATACode.AUE.toString())
				.param("adultsCount", new Integer(3).toString()).contentType("application/json"))
	            .andReturn().getResponse();
		;
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).
		isEqualTo(crazyHotelService.retriveAllCrazyHotels(
        	Instant.now(), Instant.now().minus(Duration.ofHours(5))
        	,IATACode.AUE, new Integer(3)).toString());

	}

}
