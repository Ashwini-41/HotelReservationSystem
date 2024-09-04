package com.hotelreservation;

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
	
	public List<Hotel> getHotel() {
		return hotels;
	}
}
