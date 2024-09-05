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
		hotelreservation.addHotel("vedant", 200,100);
		hotelreservation.addHotel("likehood", 250,50);
		hotelreservation.addHotel("bridgehood", 300,40);
		
	}

	
	@Test
	void testAddHotel() {
	    
		List<Hotel> hotels = hotelreservation.getHotel();
		
         assertEquals(3,hotels.size());
		assertEquals("likehood",hotels.get(1).getName());
		assertEquals(250,hotels.get(1).getWeekDayrate());
		assertEquals(50,hotels.get(1).getWeekendDayrate());
		
		assertEquals("bridgehood",hotels.get(2).getName());
		assertEquals(300,hotels.get(2).getWeekDayrate());
		assertEquals(40,hotels.get(2).getWeekendDayrate());

		
		
	} 
	
	@Test
	
	void testfindChepestHotel() {
		LocalDate startDate = LocalDate.of(2020, 9,11);//friday
		LocalDate endDate = LocalDate.of(2020, 9,12);//saturday
		
		List<Hotel> chepestHotel = hotelreservation.findcheapestHotel(startDate, endDate);
		
		assertNotNull(chepestHotel);
		assertEquals(2,chepestHotel.size());
		
		assertTrue(chepestHotel.stream().anyMatch(hotel -> hotel.getName().equals("vedant")));
		assertTrue(chepestHotel.stream().anyMatch(hotel -> hotel.getName().equals("likehood")));

		Hotel vedant = chepestHotel.stream().filter(h -> h.getName().equals("vedant")).findFirst().get();
		assertEquals(300,vedant.claculateTotalRate(startDate, endDate));
		
		Hotel likehood = chepestHotel.stream().filter(h -> h.getName().equals("likehood")).findFirst().get();
		assertEquals(300,likehood.claculateTotalRate(startDate, endDate));
		
		assertFalse(chepestHotel.stream().anyMatch(hotel -> hotel.getName().equals("bridgehood")));

	}
	

}
