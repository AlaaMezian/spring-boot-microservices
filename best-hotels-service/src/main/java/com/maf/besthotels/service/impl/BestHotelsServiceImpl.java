package com.maf.besthotels.service.impl;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maf.besthotels.domain.model.BestHotel;
import com.maf.besthotels.repository.BestHotelsRepository;
import com.maf.besthotels.service.BestHotelsService;
import com.maf.hotels.constants.IATACode;

@Service
public class BestHotelsServiceImpl implements BestHotelsService {

	@Autowired
	private BestHotelsRepository bestHotelRepo;

	public Collection<BestHotel> retriveBestHotels(LocalDate fromDate, LocalDate to, IATACode city, Integer numberOfAdults) {

		// check if date is in local iso date format and if not convert it
//        if(hotelRequest.getFromDate() instanceof Date)
//        {
//        	 LocalDate localDateFrom = hotelRequest.getFromDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        }
//        if(hotelRequest.getToDate() instanceof Date) {
//        	LocalDate localDateTo= hotelRequest.getToDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        }
		return bestHotelRepo.findAll();

	}
}
