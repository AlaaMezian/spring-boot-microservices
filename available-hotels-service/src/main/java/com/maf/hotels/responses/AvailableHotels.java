package com.maf.hotels.responses;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailableHotels {

	@ApiModelProperty(notes = "The name of the hotel service provider")
	private String provider;

	@ApiModelProperty(notes = "The name of the hotel")
	private String hotelName;

	@ApiModelProperty(notes = "The cost of hotel per night")
	private Double fare;

	@ApiModelProperty(notes = "List of aminitiest ")
	private List<String> aminities;
}
