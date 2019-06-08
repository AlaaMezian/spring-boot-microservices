package com.maf.crazyhotel.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CrazyHotel {
  
	private Integer crazyHotelId;
	private String hotelName;
	private String rate;
	private Double price;
	private String discount;
	private List<String> amenitites;
}
