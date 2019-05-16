package com.maf.aggregator.client;

import java.time.Instant;
import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Component;

import com.maf.aggregator.constant.IATACode;
import com.maf.aggregator.response.CrazyHotelResponse;

@Component
public class CrazyHotelClientFallBack implements CrazyHotelClient{

	/**
	 * @author Ala'a Mezian
	 * @return  emptyList if the crazyHotels microservice fails for some reason or its down
	 */
	@Override
	public Collection<CrazyHotelResponse> retriveCrazyHotels(Instant from, Instant toDate, IATACode city,
			Integer adultsCount) {
		System.out.println(" Warning :  Using fallback method for Crazy Hotel Service------->");
		Collection<CrazyHotelResponse>  collection = Collections.emptyList();
		return collection;	}

}
