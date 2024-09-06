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
		hotelreservation.addHotel("Ridgewood", 250,60,80,80,2);
		
		
	}
	
	
	@Test
	void testrewardCustomerCheapestHotel() throws InvalidInputException {
		//List<Hotel> hotels = hotelreservation.getHotel();
		LocalDate startDate = LocalDate.of(2020, 9,11);//friday
		LocalDate endDate = LocalDate.of(2020,9,12);//saturday
		
		List<Hotel> rewardbestratedchepestHotel = hotelreservation.findBestRatedCheapestHotel(startDate, endDate,true);
		
     	assertNotNull(rewardbestratedchepestHotel);
     	assertEquals(1,rewardbestratedchepestHotel.size());
     	assertEquals("vedant",rewardbestratedchepestHotel.get(0).getName());
     	assertEquals(160,rewardbestratedchepestHotel.get(0).claculateTotalRate(startDate, endDate, true));
	}

	@Test
	void testregularCustomerCheapestHotel1() throws InvalidInputException {
		//List<Hotel> hotels = hotelreservation.getHotel();
		LocalDate startDate = LocalDate.of(2020, 9,11);//friday
		LocalDate endDate = LocalDate.of(2020,9,12);//saturday
		
		List<Hotel> rewardbestratedchepestHotel = hotelreservation.findBestRatedCheapestHotel(startDate, endDate,false);
		
     	assertNotNull(rewardbestratedchepestHotel);
     	assertEquals(1,rewardbestratedchepestHotel.size());
     	assertEquals("vedant",rewardbestratedchepestHotel.get(0).getName());
     	assertEquals(300,rewardbestratedchepestHotel.get(0).claculateTotalRate(startDate, endDate, false));
//     	assertEquals("likehood",rewardbestratedchepestHotel.get(1).getName());
//     	assertEquals(300,rewardbestratedchepestHotel.get(1).claculateTotalRate(startDate, endDate, false));
	}
	
	@Test
	void testAddHotel() {
	    
		List<Hotel> hotels = hotelreservation.getHotel();
		
         assertEquals(4,hotels.size());
         
         assertEquals("vedant",hotels.get(0).getName());
 		assertEquals(200,hotels.get(0).getWeekDayrate());
 		assertEquals(100,hotels.get(0).getWeekendDayrate());
 		assertEquals(80,hotels.get(0).getRewardWeekdayRate());
 		assertEquals(80,hotels.get(0).getRewardWeekendRate());
 		assertEquals(4,hotels.get(0).getRating());
 		
 		
		assertEquals("likehood",hotels.get(1).getName());
		assertEquals(250,hotels.get(1).getWeekDayrate());
		assertEquals(50,hotels.get(1).getWeekendDayrate());
		assertEquals(110,hotels.get(1).getRewardWeekdayRate());
		assertEquals(90,hotels.get(1).getRewardWeekendRate());
		assertEquals(3,hotels.get(1).getRating()); //check rating
		
		assertEquals("bridgehood",hotels.get(2).getName());
		assertEquals(300,hotels.get(2).getWeekDayrate());
		assertEquals(40,hotels.get(2).getWeekendDayrate());
		assertEquals(120,hotels.get(2).getRewardWeekdayRate());
		assertEquals(80,hotels.get(2).getRewardWeekendRate());
		assertEquals(5,hotels.get(2).getRating()); //check rating

		
		
	} 
	
	
	@Test
	void testfindHighRatedHotel() throws InvalidInputException {
		LocalDate startDate = LocalDate.of(2020, 9,11);//friday
		LocalDate endDate = LocalDate.of(2020, 9,12);//saturday
		
		List<Hotel> bestratedHotel = hotelreservation.highestRatedHotel(startDate, endDate,false);
		assertNotNull(bestratedHotel);
     	assertEquals(1,bestratedHotel.size());
     	assertEquals("bridgehood" , bestratedHotel.get(0).getName());
     	assertEquals(5,bestratedHotel.get(0).getRating());
	}
	
	
	@Test
	void testfindChepestHotel() throws InvalidInputException {
		LocalDate startDate = LocalDate.of(2020, 9,11);//friday
		LocalDate endDate = LocalDate.of(2020, 9,12);//saturday
		
		List<Hotel> bestratedchepestHotel = hotelreservation.findBestRatedCheapestHotel(startDate, endDate,false);
		
     	assertNotNull(bestratedchepestHotel);
     	assertEquals(1,bestratedchepestHotel.size());
		
		assertTrue(bestratedchepestHotel.stream().anyMatch(hotel -> hotel.getName().equals("vedant")));
		assertEquals("vedant" , bestratedchepestHotel.get(0).getName());
		assertEquals(4,bestratedchepestHotel.get(0).getRating());
		assertEquals(300,bestratedchepestHotel.get(0).claculateTotalRate(startDate, endDate,false));
		
	}
	
	
	@Test
	void testInvalidInput() {
		LocalDate startDate = LocalDate.of(2020, 9,12);
		LocalDate endDate = LocalDate.of(2020, 9,11);
		
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			hotelreservation.findBestRatedCheapestHotel(startDate, endDate, true);
		});
		
		assertEquals("Start date must be before or equal to the end date.",exception.getMessage());
		
		

	} 
	
	@Test
	void testInvalidInputStartdate() {
		LocalDate startDate = LocalDate.of(2020, 9,11);
		LocalDate endDate = null;
		
		Exception exception1 = assertThrows(InvalidInputException.class, () -> {
			hotelreservation.findBestRatedCheapestHotel(startDate, endDate ,true);
		});
		assertEquals("Start date and End date cannot be null",exception1.getMessage());

		
	}

}
