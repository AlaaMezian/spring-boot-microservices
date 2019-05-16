package com.maf.aggregator.client;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Component;

import com.maf.aggregator.constant.IATACode;
import com.maf.aggregator.response.BestHotelResponse;

@Component
public class BestHotelClientFallBack implements BestHotelsClient{

	/**
	 * @author Ala'a Mezian
	 * @return  emptyList if the bestHotels microservice fails for some reason or its down
	 */
	@Override
	public Collection<BestHotelResponse> retriveBestHotels(LocalDate from, LocalDate toDate, IATACode city,
			Integer numberOfAdults) {

		System.out.println(" Warning :  Using fallback method for Best Hotel Service------->");
		Collection<BestHotelResponse>  collection = Collections.emptyList();
		return collection;
	}

}
