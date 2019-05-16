package com.maf.crazyhotels.controller;

import java.time.Instant;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maf.crazyhotel.domain.model.CrazyHotel;
import com.maf.crazyhotels.service.CrazyHotelService;
import com.maf.hotels.constants.IATACode;

@RestController
public class CrazyHotelsController {

	@Autowired
	private CrazyHotelService crazyHotelsService;

	/**
	 * @author Ala'a.mezian
	 * @description Crazy Hotels API Provider
	 * @param from        : Date
	 * @param to          : Date
	 * @param adultsCount : integer
	 * @param IATACode    : Enum representing airports code in each city therefore
	 *                    it represent the city which contain the hotel
	 * @return collection of crazy hotels
	 */
	@RequestMapping(value = "/CrazyHotels", method = RequestMethod.GET)
	public Collection<CrazyHotel> retriveCrazyHotels(@RequestParam @DateTimeFormat Instant from,
			@RequestParam Instant to, @RequestParam IATACode city, @RequestParam Integer adultsCount) {
		Collection<CrazyHotel> crazyHotels = crazyHotelsService.retriveAllCrazyHotels(from, to, city, adultsCount);
		return crazyHotels;
	}

}
