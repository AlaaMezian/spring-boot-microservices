package com.maf.crazyhotels.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.maf.crazyhotel.domain.model.CrazyHotel;

@Repository
public class CrazyHotelsRepository {

	/**
	 * Note the map is acting as a temporary data base
	 **/
	private static Map<Integer, CrazyHotel> HotelRepsitory = null;

	static {
		/**
		 * Note the stream is acting as a data source for the map
		 **/
		Stream<String> hotelsStream = Stream.of("1-Starwood-***-150.469-10%-Table Lamp, Envelopes,LED Monitor",
				"2-Marriott-****-250.605-0-Jackozi, King Size Bed",
				"3-Lime Wood-**-180-0-Large Swimming pool, Air Conditions");
		HotelRepsitory = createCrazyHotels(hotelsStream);
	}

	/**
	 * @author Ala'a Mezian
	 * @param hotelsStream :stream<string>,act as the data source of the repository             
	 * @return inserted crazy hotel object into the hash map
	 */
	public static Map<Integer, CrazyHotel> createCrazyHotels(Stream<String> hotelsStream) {
		return hotelsStream.map(hotel -> {
			String[] info = hotel.split("-");
			return createCrazyHotel(new Integer(info[0]), info[1], info[2], new Double(info[3]), info[4], info[5]);
		}).collect(Collectors.toMap(CrazyHotel::getCrazyHotelId, cHotel -> cHotel));
	}

	/**
	 * @author Ala'a Mezian
	 * @param id             :integer , the identifier of the best hotels object you
	 *                       want to create
	 * @param name           :string , name of the hotel
	 * @param hotelRate      :double , the rate of the hotel number from 1-5
	 * @param hotelprice:    double , hotel room price per night
	 * @param roomAmenities: String of amenities separated by comma
	 * @return inserted crazy hotel object
	 */
	public static CrazyHotel createCrazyHotel(Integer id, String name, String hotelRate, Double hotelFare,
			String discount, String roomAminities) {
		CrazyHotel crazyHotel = new CrazyHotel();
		crazyHotel.setCrazyHotelId(id);
		crazyHotel.setHotelName(name);
		crazyHotel.setRate(hotelRate);
		crazyHotel.setPrice(hotelFare);
		if (!discount.equals("0")) {
			crazyHotel.setDiscount(discount);
		}
		if (!roomAminities.equals(null)) {
			List<String> amenitites = new ArrayList<>();
			String[] roomAmenitiesArr = roomAminities.split(",");
			if (roomAmenitiesArr.length == 1) {
				amenitites.add(roomAmenitiesArr[0]);
			} else {
				amenitites = Arrays.asList(roomAmenitiesArr);
			}
			crazyHotel.setAmenitites(amenitites);
		}
		return crazyHotel;
	}

	public CrazyHotel findById(Long id) {
		return HotelRepsitory.get(id);
	}

	/**
	 * @author Ala'a Mezian
	 * @return a collection of all hotels in the crazy hotels provider
	 */
	public Collection<CrazyHotel> findAll() {
		return HotelRepsitory.values();
	}

}
