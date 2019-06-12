package com.maf.besthotels.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maf.besthotels.domain.model.BestHotel;
import com.maf.besthotels.dto.BestHotelDTO;
import com.maf.besthotels.exceptions.BadRequest;
import com.maf.besthotels.repository.BestHotelsRepository;
import com.maf.besthotels.service.BestHotelsService;

@Service
public class BestHotelsServiceImpl implements BestHotelsService {

	@Autowired
	private BestHotelsRepository bestHotelRepo;

	public Collection<BestHotel> retriveBestHotels(BestHotelDTO bestHotelDto) {
		if(bestHotelDto.getTo().isBefore(bestHotelDto.getFromDate())) {
			throw new BadRequest("invalid from-to period");
		}
		return bestHotelRepo.findAll();

	}
}
