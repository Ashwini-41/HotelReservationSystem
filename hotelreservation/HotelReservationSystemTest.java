package com.hotelreservation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HotelReservationSystemTest {
	
	private HotelReservationSystem hotelreservation;
	
	@BeforeEach
	public void setUp() {
		hotelreservation = new HotelReservationSystem();
	}

	@Test
	void testAddHotel() {
	    
		hotelreservation.addHotel("likehood", 200);
		hotelreservation.addHotel("bridgehood", 300);
		
		List<Hotel> hotels = hotelreservation.getHotel();
		
		assertEquals(2,hotels.size());
		assertEquals("likehood",hotels.get(0).getName());
		assertEquals(200,hotels.get(0).getRate());
		
		assertEquals("bridgehood",hotels.get(1).getName());
		assertEquals(300,hotels.get(1).getRate());
		
		
	}
	

}
