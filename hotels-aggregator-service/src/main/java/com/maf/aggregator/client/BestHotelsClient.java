package com.maf.aggregator.client;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maf.aggregator.response.BestHotelResponse;
import com.maf.hotels.constants.IATACode;

@FeignClient(name = "best-hotels-service" , fallback = BestHotelClientFallBack.class)
public interface BestHotelsClient {

	
	@RequestMapping(method = RequestMethod.GET, value = "/BestHotels" )
	public Collection<BestHotelResponse> retriveBestHotels(@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromaDate, 
			@RequestParam("toDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
			@RequestParam("city") IATACode city, @RequestParam("numberOfAdults") Integer numberOfAdults);

}
