package com.maf.crazyhotels.service;

import java.time.Instant;
import java.util.Collection;

import com.maf.crazyhotel.domain.model.CrazyHotel;
import com.maf.crazyhotel.domain.model.IATACode;

public interface CrazyHotelService {
  
	public Collection<CrazyHotel> retriveAllCrazyHotels(Instant fromDate, Instant to, IATACode city, Integer AdultsCount	);
	
}
