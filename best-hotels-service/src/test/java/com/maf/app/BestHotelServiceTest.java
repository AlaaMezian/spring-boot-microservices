package com.maf.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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

import com.maf.besthotels.app.BestHotelsServiceApplication;
import com.maf.besthotels.domain.model.BestHotel;
import com.maf.besthotels.dto.BestHotelDTO;
import com.maf.besthotels.exceptions.BadRequest;
import com.maf.besthotels.repository.BestHotelsRepository;
import com.maf.besthotels.repository.IATACode;
import com.maf.besthotels.service.BestHotelsService;
import com.maf.besthotels.service.impl.BestHotelsServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BestHotelsServiceApplication.class)
public class BestHotelServiceTest {

	@Mock
	BestHotelsRepository bestHotelRepo;

	@InjectMocks
	BestHotelsService bestHotelServiceImpl = new BestHotelsServiceImpl();

	@Before
	public void test() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetriveAllBestHotels() {
		Collection<BestHotel> hotels = new HashMap<Integer, BestHotel>() {
			{
				put(1, new BestHotel(1, "Hitlon", 4.0, 25.66, "Swna, Bean Bags , Double Size Bed"));
				put(2, new BestHotel(2, "Four Seasons", 4.5, 36.2023, "Table Lamp, Envelopes"));
			}
		}.values();
		when(bestHotelRepo.findAll()).thenReturn(hotels);
		BestHotelDTO bestHotelTest = new BestHotelDTO(LocalDate.of(2018, 02, 20), LocalDate.of(2014, 02, 20), IATACode.AUE,
				new Integer(3));
		assertThat(bestHotelServiceImpl
				.retriveBestHotels(bestHotelTest)
				.containsAll(hotels));
	}

	@Test(expected = BadRequest.class)
	public void testInvalidDate() {
		BestHotelDTO bestHotelTest = new BestHotelDTO(LocalDate.of(2018, 02, 20), LocalDate.of(2014, 02, 20), IATACode.AUE,
				new Integer(3));
		bestHotelServiceImpl.retriveBestHotels(bestHotelTest);
	}

}
