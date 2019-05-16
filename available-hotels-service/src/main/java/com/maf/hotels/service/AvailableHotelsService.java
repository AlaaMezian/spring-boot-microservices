package com.maf.hotels.service;

import java.time.LocalDate;

import com.maf.hotels.constants.IATACode;
import com.maf.hotels.responses.BaseResponse;

public interface AvailableHotelsService {

	BaseResponse retriveAllAvailableHotels(LocalDate fromDate, LocalDate toDate, IATACode city, Integer numberOfAdults);
}
