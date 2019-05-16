package com.maf.besthotels.repository;

import static com.maf.besthotels.util.NumberUtil.round;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.maf.besthotels.domain.model.BestHotel;

@Repository
public class BestHotelsRepository {


	/**
	 * Note the map is acting as a temporary data base
	 **/
	private static Map<Integer, BestHotel> HotelRepsitory = null;

	static {
		/**
		 * Note the stream is acting as a data source for the map
		 **/
		Stream<String> hotelsStream = Stream.of("1-Hitlon-4-25.659-Swna, Bean Bags , Double Size Bed",
				"2-Four Seasons-4.5-36.2023-Table Lamp, Envelopes");
		HotelRepsitory = hotelsStream.map(hotel -> {
			String[] info = hotel.split("-");
			return createBestHotels(new Integer(info[0]), info[1], new Double(info[2]), new Double(info[3]), info[4]);
		}).collect(Collectors.toMap(BestHotel::getHotelId, bHotel -> bHotel));
	}

	/**
	 * @author Ala'a Mezian
	 * @param id:integer     ,the identifier of the besthotel object you want to
	 *                       create
	 * @param name           :string , name of the hotel
	 * @param hotelRate      :double , the rate of the hotel number from 1-5
	 * @param hotelFare      : double , Total price rounded to 2 decimals
	 * @param roomAmenities: String of amenities separated by comma
	 * @return inserted best hotel object
	 */
	private static BestHotel createBestHotels(Integer id, String name, Double hotelRate, Double hotelFare,
			String roomAminities) {
		BestHotel bestHotel = new BestHotel();
		bestHotel.setHotelId(id);
		bestHotel.setHotelName(name);
		bestHotel.setHotelRate(hotelRate);
		bestHotel.setHotelFare(round(hotelFare, 2));
		bestHotel.setRoomAmenitites(roomAminities);
		return bestHotel;
	}

	/**
	 * @author Ala'a Mezian
	 * @param id:long ,the identifier of the desired hotel to be retrieved
	 * @return BestHotel object by id
	 */
	public BestHotel findById(Long id) {
		return HotelRepsitory.get(id);
	}

	/**
	 * @author Ala'a Mezian
	 * @return a collection of all hotels in the besthotel provider
	 */
	public Collection<BestHotel> findAll() {
		return HotelRepsitory.values();
	}

}
