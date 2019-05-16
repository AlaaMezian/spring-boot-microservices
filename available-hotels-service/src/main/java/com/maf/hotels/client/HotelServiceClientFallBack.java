package com.maf.hotels.client;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Component;

import com.maf.hotels.constants.IATACode;
import com.maf.hotels.responses.AvailableHotels;

@Component
public class HotelServiceClientFallBack implements HotelsServiceClient {

	@Override
	public Collection<AvailableHotels> retriveBestHotels(LocalDate from, LocalDate toDate, IATACode city,
			Integer numberOfAdults) {
		
		System.out.println(" Warning :  Using fallback method for calling Aggregate Hotel Service------->");
		Collection<AvailableHotels>  collection = Collections.emptyList();
		return collection;
	}

}
