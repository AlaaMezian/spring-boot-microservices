package com.maf.crazyhotels.service.impl;

import java.time.Instant;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maf.crazyhotel.domain.model.CrazyHotel;
import com.maf.crazyhotels.repository.CrazyHotelsRepository;
import com.maf.crazyhotels.service.CrazyHotelService;
import com.maf.hotels.constants.IATACode;

@Service
public class CrazyHotelServiceImpl implements CrazyHotelService{

	@Autowired
	private CrazyHotelsRepository crazyHotelsRepository;
	
	@Override
	public Collection<CrazyHotel> retriveAllCrazyHotels(Instant fromDate, Instant to, IATACode city, Integer AdultsCount) {
		// also use number of allowed to the filter the object  all is done throught stream api 
		return crazyHotelsRepository.findAll();
	}

}
