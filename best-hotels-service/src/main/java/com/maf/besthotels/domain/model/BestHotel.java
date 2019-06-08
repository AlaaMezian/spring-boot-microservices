package com.maf.besthotels.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BestHotel {

	private Integer hotelId;
	private String hotelName;
	private Double hotelRate;
	private Double hotelFare;
	private String roomAmenitites;
	
}
