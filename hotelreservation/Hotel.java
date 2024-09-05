package com.hotelreservation;

//import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.DayOfWeek;


public class Hotel {
   private String name;
   private double weekDayrate;
   private double weekendDayrate;
   
   public Hotel(String name, double weekDayrate,double weekendDayrate) {
	super();
	this.name = name;
	this.weekDayrate = weekDayrate;
	this.weekendDayrate = weekendDayrate;
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

public double claculateTotalRate(LocalDate startDate , LocalDate endDate) {
	
	//long totaldays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
	double totalRate = 0.0;
	
	 LocalDate date = startDate; 
			
	  while(!date.isAfter(endDate)) { 
		
		if(isWeekend(date)) {
			totalRate = totalRate + weekDayrate;
			
		}else {
			totalRate = totalRate + weekendDayrate;
		}
		date = date.plusDays(1);
	}
	  return totalRate;
	
}

private boolean isWeekend(LocalDate date) {
	DayOfWeek day = date.getDayOfWeek();
    return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
}

@Override
public String toString() {
	return "Hotel [name=" + name + ", weekDayrate=" + weekDayrate + ", weekendDayrate=" + weekendDayrate + "]";
}




 
   
}
