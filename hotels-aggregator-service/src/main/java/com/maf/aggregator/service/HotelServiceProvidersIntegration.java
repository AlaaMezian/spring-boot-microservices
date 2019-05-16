package com.maf.aggregator.service;

import java.time.LocalDate;
import java.util.List;

import com.maf.aggregator.response.HotelCustomResponse;
import com.maf.hotels.constants.IATACode;


public interface HotelServiceProvidersIntegration {
   
	List<HotelCustomResponse> retriveHotelsFromProviders(LocalDate fromDate, LocalDate to, IATACode city, Integer numberOfAdults);
}
