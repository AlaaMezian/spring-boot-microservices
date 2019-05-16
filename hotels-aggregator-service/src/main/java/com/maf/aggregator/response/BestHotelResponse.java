package com.maf.aggregator.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BestHotelResponse {

	private Integer hotelId;
	private String hotelName;
	private Double hotelRate;
	private Double hotelFare;
	private String roomAmenitites;

}
