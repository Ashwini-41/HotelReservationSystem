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
		hotelreservation.addHotel("vedant", 200,100,80,80,4);
		hotelreservation.addHotel("likehood", 250,50,110,90,3);
		hotelreservation.addHotel("bridgehood", 300,40,120,80,5);
		
	}
	
	@Test
	void testrewardCustomerCheapestHotel() {
		//List<Hotel> hotels = hotelreservation.getHotel();
		LocalDate startDate = LocalDate.of(2020, 9,11);//friday
		LocalDate endDate = LocalDate.of(2020, 9,12);//saturday
		
		List<Hotel> rewardbestratedchepestHotel = hotelreservation.findcheapestHotel(startDate, endDate,true);
		
     	assertNotNull(rewardbestratedchepestHotel);
     	assertEquals(1,rewardbestratedchepestHotel.size());
     	assertEquals("vedant",rewardbestratedchepestHotel.get(0).getName());
     	assertEquals(160,rewardbestratedchepestHotel.get(0).claculateTotalRate(startDate, endDate, true));
	}

	
	@Test
	void testAddHotel() {
	    
		List<Hotel> hotels = hotelreservation.getHotel();
		
         assertEquals(3,hotels.size());
		assertEquals("likehood",hotels.get(1).getName());
		assertEquals(250,hotels.get(1).getWeekDayrate());
		assertEquals(50,hotels.get(1).getWeekendDayrate());
		assertEquals(3,hotels.get(1).getRating()); //check rating
		
		assertEquals("bridgehood",hotels.get(2).getName());
		assertEquals(300,hotels.get(2).getWeekDayrate());
		assertEquals(40,hotels.get(2).getWeekendDayrate());
		assertEquals(5,hotels.get(2).getRating()); //check rating

		
		
	} 
	
	
	@Test
	void testfindHighRatedHotel() {
		LocalDate startDate = LocalDate.of(2020, 9,11);//friday
		LocalDate endDate = LocalDate.of(2020, 9,12);//saturday
		
		List<Hotel> bestratedHotel = hotelreservation.highestRatedHotel(startDate, endDate,false);
		assertNotNull(bestratedHotel);
     	assertEquals(1,bestratedHotel.size());
     	assertEquals("bridgehood" , bestratedHotel.get(0).getName());
     	assertEquals(5,bestratedHotel.get(0).getRating());
	}
	
	
	@Test
	void testfindChepestHotel() {
		LocalDate startDate = LocalDate.of(2020, 9,11);//friday
		LocalDate endDate = LocalDate.of(2020, 9,12);//saturday
		
		List<Hotel> bestratedchepestHotel = hotelreservation.findcheapestHotel(startDate, endDate,false);
		
     	assertNotNull(bestratedchepestHotel);
     	assertEquals(1,bestratedchepestHotel.size());
		
		assertTrue(bestratedchepestHotel.stream().anyMatch(hotel -> hotel.getName().equals("vedant")));
		assertEquals("vedant" , bestratedchepestHotel.get(0).getName());
		assertEquals(4,bestratedchepestHotel.get(0).getRating());
		assertEquals(300,bestratedchepestHotel.get(0).claculateTotalRate(startDate, endDate,false));
		
	}
	
	

}
