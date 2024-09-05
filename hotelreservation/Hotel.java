package com.hotelreservation;

//import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.DayOfWeek;


public class Hotel {
   private String name;
   private double weekDayrate;
   private double weekendDayrate;
   private double rewardWeekdayRate;
   private double rewardWeekendRate;
   private int rating;
   
   public Hotel(String name, double weekDayrate,double weekendDayrate , double rewardWeekdayRate,double rewardWeekendRate, int rating) {
	super();
	this.name = name;
	this.weekDayrate = weekDayrate;
	this.weekendDayrate = weekendDayrate;
	this.rewardWeekdayRate = rewardWeekdayRate;
	this.rewardWeekendRate = rewardWeekendRate;
	this.rating = rating;
   }



public String getName() {
	return name;
}


public double getWeekDayrate() {
	return weekDayrate;
}




public double getWeekendDayrate() {
	return weekendDayrate;
}

public double getRewardWeekendRate() {
	return rewardWeekendRate;
}

public double getRewardWeekdayRate() {
	return rewardWeekdayRate;
}

public int getRating() {
	return rating;
}

public double claculateTotalRate(LocalDate startDate , LocalDate endDate ,boolean isRewardCustomer) {
	
	//long totaldays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
	double totalRate = 0.0;
	
	 LocalDate date = startDate; 
			
	  while(!date.isAfter(endDate)) { 
		
		  boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SATURDAY || 
				  date.getDayOfWeek() == DayOfWeek.SUNDAY;
		  
		  if(isRewardCustomer) {
			  totalRate +=  isWeekend ? rewardWeekendRate :rewardWeekdayRate;
		  }else {
			  totalRate +=  isWeekend ? weekendDayrate :weekDayrate;
		  }
		  
		  date = date.plusDays(1);
		  
	}
	  return totalRate;
	
}

/*
private boolean isWeekend(LocalDate date) {
	DayOfWeek day = date.getDayOfWeek();
    return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
} */

@Override
public String toString() {
	return "Hotel [name=" + name + ", weekDayrate=" + weekDayrate + ", weekendDayrate=" + weekendDayrate + "rewardWeekdayRate= " +rewardWeekdayRate + "rewardWeekendRate= " + rewardWeekendRate + "Rating= " + rating +" ]";
}




 
   
}
