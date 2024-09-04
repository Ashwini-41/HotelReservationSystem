package com.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
          
	private List<Hotel> hotels;
	
	public HotelReservationSystem() {
		this.hotels = new ArrayList<>();
	}
	
	public void addHotel(String name, double rate) {
		Hotel hotel = new Hotel(name,rate);
		hotels.add(hotel);
	}
	
	public Hotel findcheapestHotel(LocalDate startTime, LocalDate endTime) {
		
//		return hotels.stream()
//				.min(hotel1 , hotel2) -> {
//					
//				}
		Hotel chepestHotel = null;
		double minRate = Double.MAX_VALUE;
		for(Hotel hotel : hotels) {
			double totalRate = hotel.claculateTotalRate(startTime, endTime);
			
			if(totalRate < minRate) {
				minRate = totalRate;
				chepestHotel = hotel;
			}
		}
		return chepestHotel;
	
		
		
	}
	
	public List<Hotel> getHotel() {
		return hotels;
	}
}
