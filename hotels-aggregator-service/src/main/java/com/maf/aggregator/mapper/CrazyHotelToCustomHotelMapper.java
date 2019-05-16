package com.maf.aggregator.mapper;

import com.maf.aggregator.response.CrazyHotelResponse;
import com.maf.aggregator.response.HotelCustomResponse;

public class CrazyHotelToCustomHotelMapper {

	public static HotelCustomResponse map(CrazyHotelResponse crazyHotel) {

		HotelCustomResponse hotelCustomResponse = new HotelCustomResponse();
		hotelCustomResponse.setProvider("Crazy Hotels");
		hotelCustomResponse.setHotelName(crazyHotel.getHotelName());
		hotelCustomResponse.setFare(crazyHotel.getPrice());
		hotelCustomResponse.setAminities(crazyHotel.getAmenitites());
		hotelCustomResponse.setRate((double) crazyHotel.getRate().length());
		return hotelCustomResponse;

	}
}
