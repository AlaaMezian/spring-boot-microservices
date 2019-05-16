package com.maf.crazyhotel.domain.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CrazyHotel {
  
	private Integer crazyHotelId;
	private String hotelName;
	private String rate;
	private Double price;
	private String discount;
	private List<String> amenitites;
}
