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
		hotelreservation.addHotel("vedant", 200,90);
		hotelreservation.addHotel("likehood", 100,50);
		hotelreservation.addHotel("bridgehood", 300,40);
		
	}

	
	@Test
	void testAddHotel() {
	    
		List<Hotel> hotels = hotelreservation.getHotel();
		
         assertEquals(3,hotels.size());
		assertEquals("likehood",hotels.get(1).getName());
		assertEquals(100,hotels.get(1).getWeekDayrate());
		assertEquals(50,hotels.get(1).getWeekendDayrate());
		
		assertEquals("bridgehood",hotels.get(2).getName());
		assertEquals(300,hotels.get(2).getWeekDayrate());
		assertEquals(40,hotels.get(2).getWeekendDayrate());

		
		
	} 
	
	@Test
	
	void testfindChepestHotel() {
		LocalDate startDate = LocalDate.of(2024, 9,7);
		LocalDate endDate = LocalDate.of(2024, 9,8);
		
		Hotel chepestHotel = hotelreservation.findcheapestHotel(startDate, endDate);
		
		assertNotNull(chepestHotel);
		assertEquals("likehood",chepestHotel.getName());
		assertEquals(200,chepestHotel.claculateTotalRate(startDate, endDate));
		
	}
	

}
