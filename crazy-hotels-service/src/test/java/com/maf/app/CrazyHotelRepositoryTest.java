package com.maf.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.maf.crazyhotel.domain.model.CrazyHotel;
import com.maf.crazyhotels.app.CrazyHotelsServiceApplication;
import com.maf.crazyhotels.repository.CrazyHotelsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrazyHotelsServiceApplication.class)
public class CrazyHotelRepositoryTest {

	@MockBean
	CrazyHotelsRepository crazyHotelRepo;

	Map<Integer, CrazyHotel> HotelRepository;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		Stream<String> hotelsStream = Stream.of("1-Starwood-***-150.469-10%-Table Lamp,Envelopes,LED Monitor",
				"2-Marriott-****-250.605-0-Jackozi,King Size Bed",
				"3-Lime Wood-**-180-0-Large Swimming pool,Air Conditions");
		HotelRepository = CrazyHotelsRepository.createCrazyHotels(hotelsStream);
	}

	@Test
	public void givenValidInputStreamAsCrazyHotel_ThenGetHotelById() {

		CrazyHotel testHotel = new CrazyHotel(1, "Starwood", "***", 150.469, "10%",
				Arrays.asList("Table Lamp", "Envelopes", "LED Monitor"));
		when(crazyHotelRepo.findById(1L)).thenReturn(testHotel);

		assertThat(HotelRepository.get(1)).isEqualToComparingFieldByField(crazyHotelRepo.findById(1L));
	}

	@Test
	public void givenValidInputStream_ThenTestFindAll() {
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
		when(crazyHotelRepo.findAll()).thenReturn(hotels);
		assertThat(HotelRepository.values().containsAll(hotels));
		assertThat(HotelRepository,IsMapContaining.hasKey(1));
		assertThat(HotelRepository,IsMapContaining.hasKey(2));
		assertThat(HotelRepository,IsMapContaining.hasKey(3));

	}

	@Test
	public void givenValidInputStreamAsCrazyHotels_ThenCreateCrazyHotels() {

		CrazyHotel testHotel = new CrazyHotel(1, "Starwood", "***", 150.469, "10%",
				Arrays.asList("Table Lamp", "Envelopes", "LED Monitor"));
		assertThat(HotelRepository.get(1)).isEqualToComparingFieldByField(testHotel);
	}

}
