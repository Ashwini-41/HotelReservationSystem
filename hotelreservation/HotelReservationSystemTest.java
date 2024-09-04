package com.hotelreservation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HotelReservationSystemTest {
	
	private HotelReservationSystem hotelreservation;
	
	@BeforeEach
	public void setUp() {
		hotelreservation = new HotelReservationSystem();
		hotelreservation.addHotel("vedant", 220);
		hotelreservation.addHotel("likehood", 100);
		hotelreservation.addHotel("bridgehood", 300);
		
	}

	
	@Test
	void testAddHotel() {
	    
		List<Hotel> hotels = hotelreservation.getHotel();
		
		assertEquals(3,hotels.size());
		assertEquals("likehood",hotels.get(1).getName());
		assertEquals(100,hotels.get(1).getRate());
		
		assertEquals("bridgehood",hotels.get(2).getName());
		assertEquals(300,hotels.get(2).getRate());
		
		
	} 
	
	@Test
	
	void testfindChepestHotel() {
		LocalDate startDate = LocalDate.of(2024, 9,15);
		LocalDate endDate = LocalDate.of(2024, 9,30);
		
		Hotel chepestHotel = hotelreservation.findcheapestHotel(startDate, endDate);
		
		assertNotNull(chepestHotel);
		assertEquals("likehood",chepestHotel.getName());
		assertEquals(1500,chepestHotel.claculateTotalRate(startDate, endDate));
		
	}
	

}
