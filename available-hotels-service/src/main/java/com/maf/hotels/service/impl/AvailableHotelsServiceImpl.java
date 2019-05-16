package com.maf.hotels.service.impl;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maf.hotel.exceptions.BadRequestException;
import com.maf.hotels.client.HotelsServiceClient;
import com.maf.hotels.constants.IATACode;
import com.maf.hotels.responses.AvailableHotels;
import com.maf.hotels.responses.BaseResponse;
import com.maf.hotels.responses.ListResponse;
import com.maf.hotels.service.AvailableHotelsService;

@Service
public class AvailableHotelsServiceImpl implements AvailableHotelsService {

	@Autowired
	private HotelsServiceClient hotelServiceClient;

	@Override
	public BaseResponse retriveAllAvailableHotels(LocalDate fromDate, LocalDate toDate, IATACode city,
			Integer numberOfAdults) {
		if (fromDate.isAfter(toDate)) {
			throw new BadRequestException("please enter a valid from - to period");
		}
		if (numberOfAdults <= 0) {
			throw new BadRequestException("number of adults should be more than zero ");
		}
		Collection<AvailableHotels> availableHotels = hotelServiceClient.retriveBestHotels(fromDate, toDate, city,
				numberOfAdults);
		return ListResponse.found(availableHotels);
	}

}
