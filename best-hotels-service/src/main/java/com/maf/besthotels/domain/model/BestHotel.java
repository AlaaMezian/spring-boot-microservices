package com.maf.besthotels.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BestHotel {

	private Integer hotelId;
	private String hotelName;
	private Double hotelRate;
	private Double hotelFare;
	private String roomAmenitites;
	
}
