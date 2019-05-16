package com.maf.aggregator.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.maf.aggregator.response.BestHotelResponse;
import com.maf.aggregator.response.HotelCustomResponse;

public class BestHotelToCustomHotelMapper {

	public static HotelCustomResponse map(BestHotelResponse bestHotelRes) {

		HotelCustomResponse hotelCustomResponse = new HotelCustomResponse();
		hotelCustomResponse.setProvider("Best Hotels");
		hotelCustomResponse.setHotelName(bestHotelRes.getHotelName());
		hotelCustomResponse.setFare(bestHotelRes.getHotelFare());
		if (!bestHotelRes.getRoomAmenitites().equals(null) && bestHotelRes.getRoomAmenitites() instanceof String) {
			String[] bestHotelAminities = bestHotelRes.getRoomAmenitites().split(",");
			List<String> aminities = new ArrayList<>();
			aminities = Arrays.asList(bestHotelAminities);
			hotelCustomResponse.setAminities(aminities);
		}
		hotelCustomResponse.setRate(bestHotelRes.getHotelRate());
		return hotelCustomResponse;

	}
}
