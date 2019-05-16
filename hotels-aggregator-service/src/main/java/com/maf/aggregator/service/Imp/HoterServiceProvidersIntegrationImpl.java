package com.maf.aggregator.service.Imp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maf.aggregator.client.BestHotelsClient;
import com.maf.aggregator.client.CrazyHotelClient;
import com.maf.aggregator.mapper.BestHotelToCustomHotelMapper;
import com.maf.aggregator.mapper.CrazyHotelToCustomHotelMapper;
import com.maf.aggregator.response.BestHotelResponse;
import com.maf.aggregator.response.CrazyHotelResponse;
import com.maf.aggregator.response.HotelCustomResponse;
import com.maf.aggregator.service.HotelServiceProvidersIntegration;
import com.maf.hotels.constants.IATACode;

@Service
public class HoterServiceProvidersIntegrationImpl implements HotelServiceProvidersIntegration {

	@Autowired
	private BestHotelsClient bestHotelClient;

	@Autowired
	private CrazyHotelClient crazyHotelClient;

	/**
	 * @author Ala'a Mezian
	 * @param fromDate        :Date
	 * @param to              :Date
	 * @param city            :IATACode
	 * @param numberOfAdults  :Integer
	 * @return this function return a list of hotels from all providers ,if a new
	 *         provider is added this function is the only one that should be
	 *         changed
	 */
	@Override
	public List<HotelCustomResponse> retriveHotelsFromProviders(LocalDate fromDate, LocalDate to, IATACode city,
			Integer numberOfAdults) {
		Collection<HotelCustomResponse> hotelsFromBestHotelProvider = callBestHotelProvider(fromDate, to, city,
				numberOfAdults);

		Collection<HotelCustomResponse> hotelsFromCrazyHotelProvider = callCrazyHotelProvider(fromDate, to, city,
				numberOfAdults);

		ArrayList<HotelCustomResponse> availableHtoels = Stream
				.of(hotelsFromBestHotelProvider, hotelsFromCrazyHotelProvider).flatMap(x -> x.stream())
				.sorted((h1, h2)->h2.getRate().compareTo(h1.getRate()))
				.collect(Collectors.toCollection(ArrayList::new));
		return availableHtoels;
	}

	public Collection<HotelCustomResponse> callCrazyHotelProvider(LocalDate fromDate, LocalDate to, IATACode city,
			Integer adultsCount) {
		Instant from = fromDate.atStartOfDay().toInstant(ZoneOffset.UTC);
		Instant toDate = to.atStartOfDay().toInstant(ZoneOffset.UTC);
		Collection<CrazyHotelResponse> crazyHotelsResponses = crazyHotelClient.retriveCrazyHotels(from, toDate, city,
				adultsCount);

		return convertCrazyHotelsToHotelCustomResponse(crazyHotelsResponses);
	}

	/**
	 * @author Ala'a Mezian
	 * @param crazyHotelResponses   :represent the collection received from the crazy
	 *                               hotel provider
	 * @return hotelCustomResponses : represent a collection of hotels converted
	 *                               into another JSON Format(available hotel format)
	 */
	private Collection<HotelCustomResponse> convertCrazyHotelsToHotelCustomResponse(
			Collection<CrazyHotelResponse> crazyHotelResponses) {
		Collection<HotelCustomResponse> hotelCustomResponses = new ArrayList(crazyHotelResponses.size());
		for (CrazyHotelResponse crazyHotel : crazyHotelResponses) {
			hotelCustomResponses.add(CrazyHotelToCustomHotelMapper.map(crazyHotel));
		}
		return hotelCustomResponses;
	}

	/**
	 * @author Ala'a Mezian
	 * @param from:Local_ISO_FORMAT
	 * @param to:Local_ISO_FORMAT
	 * @param city:IATACode
	 * @param numberOfAdults:Integer
	 * @return hotelCustomResponses : represent a collection of hotels converted
	 *         into another JSON Format
	 */
	public Collection<HotelCustomResponse> callBestHotelProvider(LocalDate fromDate, LocalDate to, IATACode city,
			Integer numberOfAdults) {
		Collection<BestHotelResponse> bestHotelResponses = bestHotelClient.retriveBestHotels(fromDate, to, city,
				numberOfAdults);

		return convertBestHotelToHotelCustomResponse(bestHotelResponses);
	}

	/**
	 * @author Ala'a Mezian
	 * @param bestHotelResponses :represent the collection received from the best
	 *                           hotel provider
	 * @return hotelCustomResponses : represent a collection of hotels converted
	 *         into another JSON Format(hotel custom response)
	 */
	private Collection<HotelCustomResponse> convertBestHotelToHotelCustomResponse(
			Collection<BestHotelResponse> bestHotelsResposes) {
		Collection<HotelCustomResponse> hotelCustomResponses = new ArrayList(bestHotelsResposes.size());
		for (BestHotelResponse bestHotel : bestHotelsResposes) {
			hotelCustomResponses.add(BestHotelToCustomHotelMapper.map(bestHotel));
		}
		return hotelCustomResponses;
	}

}
