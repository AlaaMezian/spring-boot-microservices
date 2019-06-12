package com.maf.besthotels.dto;

import java.time.LocalDate;

import com.maf.besthotels.repository.IATACode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BestHotelDTO {

	private LocalDate fromDate;
	private LocalDate to;
	private IATACode city;
	private Integer numberOfAdults;
}
