package com.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
          
	private List<Hotel> hotels;
	
	public HotelReservationSystem() {
		this.hotels = new ArrayList<>();
	}
	
	public void addHotel(String name, double weekDayrate, double weekendDayrate , int rating) {
		Hotel hotel = new Hotel(name, weekDayrate,weekendDayrate ,rating);
		hotels.add(hotel);
	}
	
	public List<Hotel> findcheapestHotel(LocalDate startTime, LocalDate endTime) {

		List<Hotel> chepestHotel = new ArrayList<>();
		double minRate = Double.MAX_VALUE;
		for(Hotel hotel : hotels) {
			double totalRate = hotel.claculateTotalRate(startTime, endTime);
			
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
