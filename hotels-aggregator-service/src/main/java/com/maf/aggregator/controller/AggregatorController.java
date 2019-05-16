package com.maf.aggregator.controller;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maf.aggregator.response.HotelCustomResponse;
import com.maf.aggregator.service.HotelServiceProvidersIntegration;
import com.maf.hotels.constants.IATACode;

@RestController
public class AggregatorController {

	@Autowired
	private HotelServiceProvidersIntegration hotelProvidersService;

	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public Collection<HotelCustomResponse> retriveHotelsFromProviders(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate, @RequestParam IATACode city,
			@RequestParam Integer numberOfAdults) {
		Collection<HotelCustomResponse> hotels = hotelProvidersService.retriveHotelsFromProviders(fromDate, toDate,
				city, numberOfAdults);
		return  hotels;
	}
}
