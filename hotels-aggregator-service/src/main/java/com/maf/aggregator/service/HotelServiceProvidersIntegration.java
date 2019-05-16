package com.maf.aggregator.service;

import java.time.LocalDate;
import java.util.List;

import com.maf.aggregator.constant.IATACode;
import com.maf.aggregator.response.HotelCustomResponse;


public interface HotelServiceProvidersIntegration {
   
	List<HotelCustomResponse> retriveHotelsFromProviders(LocalDate fromDate, LocalDate to, IATACode city, Integer numberOfAdults);
}
