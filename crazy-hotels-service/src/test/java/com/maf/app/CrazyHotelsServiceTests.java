package com.maf.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maf.crazyhotel.domain.model.CrazyHotel;
import com.maf.crazyhotel.domain.model.IATACode;
import com.maf.crazyhotels.app.CrazyHotelsServiceApplication;
import com.maf.crazyhotels.exception.BadRequest;
import com.maf.crazyhotels.repository.CrazyHotelsRepository;
import com.maf.crazyhotels.service.CrazyHotelService;
import com.maf.crazyhotels.service.impl.CrazyHotelServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrazyHotelsServiceApplication.class)
public class CrazyHotelsServiceTests {

	@Mock
	CrazyHotelsRepository hotelRepo;

	@InjectMocks
	CrazyHotelService crazyHotelServiceImpl = new CrazyHotelServiceImpl();

	@Before
	public void test() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetriveAllCrazyHotels() {
		Collection<CrazyHotel> hotels = new HashMap<Integer, CrazyHotel>() {
			{
				put(1, new CrazyHotel(1, "Starwood", "***", 150.469, "10%",
						Arrays.asList("Jackozi", "Envelopes", "LED Monitor")));
				put(2, new CrazyHotel(2, "Marriott", "****", 250.605, "0%",
						Arrays.asList("Table Lamp", "King Size Bed")));
				put(3, new CrazyHotel(3, "Lime Wood", "**", 180.0, "0%",
						Arrays.asList("Large Swimming pool", "Air Conditions")));
			}
		}.values();
		when(hotelRepo.findAll()).thenReturn(hotels);
		assertThat(crazyHotelServiceImpl.retriveAllCrazyHotels(Instant.now(),
				Instant.now().minus(Duration.ofHours(5).plusMinutes(4)), IATACode.AUE, 3).containsAll(hotels));
	}

	@Test(expected = BadRequest.class)
	public void testInvalidDate() {
		crazyHotelServiceImpl.retriveAllCrazyHotels(Instant.now(),
				Instant.now().plus(Duration.ofHours(5).plusMinutes(4)), IATACode.AUE, 3);
	}

}
