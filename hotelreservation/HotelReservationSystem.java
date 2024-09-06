package com.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReservationSystem {
          
	private List<Hotel> hotels;
		
	public HotelReservationSystem() {
		this.hotels = new ArrayList<>();
	}
	
	public void addHotel(String name, double weekDayrate, double weekendDayrate ,double rewardWeekdayRate,double rewardWeekendRate, int rating) {
		Hotel hotel = new Hotel(name, weekDayrate,weekendDayrate ,rewardWeekdayRate,rewardWeekendRate,rating);
		hotels.add(hotel);
	}
	

	public void validInput(LocalDate startTime, LocalDate endTime , boolean isRewardCustomer) throws InvalidInputException{
		if(startTime == null || endTime == null) {
			throw new InvalidInputException("Start date and End date cannot be null");
		}
		
		if(startTime.isAfter(endTime)) {
			throw new InvalidInputException("Start date must be before or equal to the end date.");
			
		}
		
		if(!isRewardCustomer && isRewardCustomer) {
			throw new InvalidInputException("Invalid customer type");
		}
	}
	
	public List<Hotel> highestRatedHotel(LocalDate startTime, LocalDate endTime , boolean isRewardCustomer){
		
		int highestRating = Integer.MIN_VALUE;
		List<Hotel> HighRatedcheapestHotel = new ArrayList<>();
		
		for(Hotel hotel : hotels) {
			if(hotel.getRating() > highestRating) {
				highestRating = hotel.getRating();
				HighRatedcheapestHotel.clear();
				HighRatedcheapestHotel.add(hotel);
			}else if(highestRating == hotel.getRating() ) {
				HighRatedcheapestHotel.add(hotel);
			}
		}
	
		return HighRatedcheapestHotel;
		
	}
	
	//find best rated cheapest hotel using stream
	public List<Hotel> findBestRatedCheapestHotel(LocalDate startTime, LocalDate endTime , boolean isRewardCustomer) throws InvalidInputException{
		validInput(startTime,endTime,isRewardCustomer);
		
		List<Hotel> bestRatedCheapestHotels = hotels.stream()
				.sorted(Comparator.comparingDouble(hotel -> hotel.claculateTotalRate(startTime, endTime, isRewardCustomer)))
				.filter(hotel -> hotel.claculateTotalRate(startTime, endTime, isRewardCustomer) == hotels.stream()
				     .mapToDouble(h -> h.claculateTotalRate(startTime, endTime, isRewardCustomer))
				     .min()
				     .orElse(Double.MAX_VALUE))
				.sorted(Comparator.comparing(Hotel::getRating).reversed())
				.collect(Collectors.toList());
	
		return bestRatedCheapestHotels;

	}
	
	public List<Hotel> getHotel() {
		return hotels;
	}
}
