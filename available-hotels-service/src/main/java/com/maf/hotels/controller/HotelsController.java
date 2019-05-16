package com.maf.hotels.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maf.hotels.constants.IATACode;
import com.maf.hotels.responses.AvailableHotels;
import com.maf.hotels.responses.BaseResponse;
import com.maf.hotels.service.AvailableHotelsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class HotelsController {

	@Autowired
	private AvailableHotelsService availableHotelService;

	@RequestMapping(value = "/AvailableHotel", method = RequestMethod.GET)
	@ApiOperation(value = "View a list of available events in the system ordered by hotel rate", response = AvailableHotels.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 500, message = "internal server error,the server might be down") })
	BaseResponse retriveAvailableHotels(@ApiParam(value="2008-09-15") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate, @RequestParam IATACode city,
			@RequestParam Integer numberOfAdults) {

		return availableHotelService.retriveAllAvailableHotels(fromDate, toDate, city, numberOfAdults);

	}

}
