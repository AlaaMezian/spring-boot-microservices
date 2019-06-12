package com.maf.besthotels.service;

import java.util.Collection;

import com.maf.besthotels.domain.model.BestHotel;
import com.maf.besthotels.dto.BestHotelDTO;

public interface BestHotelsService {

	public Collection<BestHotel> retriveBestHotels(BestHotelDTO bestHotelDto);

}
