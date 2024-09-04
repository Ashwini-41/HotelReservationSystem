package com.hotelreservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
          
	private List<Hotel> hotels;
	
	public HotelReservationSystem() {
		this.hotels = new ArrayList<>();
	}
	
	public void addHotel(String name, double weekDayrate, double weekendDayrate) {
		Hotel hotel = new Hotel(name, weekDayrate,weekendDayrate);
		hotels.add(hotel);
	}
	
	public Hotel findcheapestHotel(LocalDate startTime, LocalDate endTime) {

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
