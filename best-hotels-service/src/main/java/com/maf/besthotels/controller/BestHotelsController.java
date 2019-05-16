package com.maf.besthotels.controller;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maf.besthotels.domain.model.BestHotel;
import com.maf.besthotels.service.BestHotelsService;
import com.maf.besthotels.util.IATACode;

@RestController
public class BestHotelsController {

	@Autowired
	private BestHotelsService bestHotelService;

	/**
	 * @author Ala'a.mezian
	 * @description Best Hotels API Provider
	 * @param hotelRequest consist of the following params: 
	 *  from : Date 
	 *  to : Date
	 *  numberOfAdults : integer
	 *  IATACode : Enum representing airports code in each city therefore it represent the city which contain the hotel
	 * @return Collection of best hotels
	 */
	@RequestMapping(value = "/BestHotels", method = RequestMethod.GET)
	public Collection<BestHotel> retriveBestHotels(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate ,
			@RequestParam   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate , @RequestParam IATACode city , @RequestParam Integer numberOfAdults) {
		Collection<BestHotel> bestHotels = bestHotelService.retriveBestHotels(fromDate,toDate,city,numberOfAdults);
		return bestHotels;
	}
}
