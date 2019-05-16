package com.maf.besthotels.service.impl;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maf.besthotels.domain.model.BestHotel;
import com.maf.besthotels.repository.BestHotelsRepository;
import com.maf.besthotels.repository.IATACode;
import com.maf.besthotels.service.BestHotelsService;

@Service
public class BestHotelsServiceImpl implements BestHotelsService {

	@Autowired
	private BestHotelsRepository bestHotelRepo;

	public Collection<BestHotel> retriveBestHotels(LocalDate fromDate, LocalDate to, IATACode city, Integer numberOfAdults) {
		return bestHotelRepo.findAll();

	}
}
