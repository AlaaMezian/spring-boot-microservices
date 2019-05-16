package com.maf.aggregator.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CrazyHotelResponse {

	private Integer crazyHotelId;
	private String hotelName;
	private String rate;
	private Double price;
	private String discount;
	private List<String> amenitites;
}
