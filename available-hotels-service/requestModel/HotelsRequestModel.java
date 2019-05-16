package com.maf.requestModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.maf.constants.IATACode;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HotelsRequestModel {

	@JsonAlias({ "fromDate", "from" })
	private Date fromDate;
	private Date toDate;
	private IATACode city;
	@JsonAlias({ "numberOfAdults", "adultsCount" })
	private Integer numberOfAdults;

}
