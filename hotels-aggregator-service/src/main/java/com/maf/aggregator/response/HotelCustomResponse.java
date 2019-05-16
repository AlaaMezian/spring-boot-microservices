package com.maf.aggregator.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelCustomResponse {

	private String provider;
	private String hotelName;
	private Double fare;
    private Double rate;
	private List<String> aminities;

}
