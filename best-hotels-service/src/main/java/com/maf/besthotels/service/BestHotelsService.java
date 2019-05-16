package com.maf.besthotels.service;

import java.time.LocalDate;
import java.util.Collection;

import com.maf.besthotels.domain.model.BestHotel;
import com.maf.hotels.constants.IATACode;

public interface BestHotelsService {

	public Collection<BestHotel> retriveBestHotels(LocalDate fromDate, LocalDate to, IATACode city, Integer numberOfAdults);

}
