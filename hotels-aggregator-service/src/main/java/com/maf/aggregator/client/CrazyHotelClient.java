package com.maf.aggregator.client;

import java.time.Instant;
import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maf.aggregator.response.CrazyHotelResponse;
import com.maf.hotels.constants.IATACode;

@FeignClient(name = "crazy-hotels-service" , fallback = CrazyHotelClientFallBack.class)
public interface CrazyHotelClient {

	@RequestMapping(method = RequestMethod.GET, value = "/CrazyHotels")
	public Collection<CrazyHotelResponse> retriveCrazyHotels(@RequestParam("from") Instant from,
			@RequestParam("to") Instant toDate, @RequestParam("city") IATACode city,
			@RequestParam("adultsCount") Integer adultsCount);
}
