package com.maf.hotels.client;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maf.hotels.constants.IATACode;
import com.maf.hotels.responses.AvailableHotels;


@FeignClient(name = "hotels-aggregator-service" , fallback = HotelServiceClientFallBack.class)
public interface HotelsServiceClient {

	
	@RequestMapping(method = RequestMethod.GET, value="/hotels"  )
	public Collection<AvailableHotels> retriveBestHotels(@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from, 
			@RequestParam("toDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
			@RequestParam("city") IATACode city, @RequestParam("numberOfAdults") Integer numberOfAdults);
}
