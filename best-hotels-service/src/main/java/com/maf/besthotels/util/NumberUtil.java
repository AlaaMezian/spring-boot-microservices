package com.maf.besthotels.util;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class NumberUtil {

	/**
	 * @author Ala'a Mezian
	 * @param  value:double ,value that need to be rounded
	 * @param places :integer , number of digits that the value should be rounded to 
	 * @return  the value of the number rounded to the desired decimal points 
	 */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
