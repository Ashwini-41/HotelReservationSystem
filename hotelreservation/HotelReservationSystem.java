package com.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Hotel> findcheapestHotel(LocalDate startTime, LocalDate endTime , boolean isRewardCustomer) throws InvalidInputException {
		validInput(startTime,endTime,isRewardCustomer);
		List<Hotel> chepestHotel = new ArrayList<>();
		double minRate = Double.MAX_VALUE;
		for(Hotel hotel : hotels) {
			double totalRate = hotel.claculateTotalRate(startTime, endTime ,isRewardCustomer);
			
			if(totalRate < minRate) {
				minRate = totalRate;
				chepestHotel.clear();
				chepestHotel.add(hotel);
			}else if(totalRate == minRate) {
				chepestHotel.add(hotel);
			}
		}
		//return chepestHotel;
		
		int highestRating = Integer.MIN_VALUE;
		List<Hotel> HighRatedcheapestHotel = new ArrayList<>();
		
		for(Hotel hotel : chepestHotel) {
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
	
	public List<Hotel> getHotel() {
		return hotels;
	}
}
