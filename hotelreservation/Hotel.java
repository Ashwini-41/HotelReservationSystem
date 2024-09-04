package com.hotelreservation;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Hotel {
   private String name;
   private double rate;
   
   public Hotel(String name, double rate) {
	super();
	this.name = name;
	this.rate = rate;
   }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getRate() {
	return rate;
}

public void setRate(double rate) {
	this.rate = rate;
}

public double claculateTotalRate(LocalDate startTime , LocalDate endTime) {
	
	long days = ChronoUnit.DAYS.between(startTime, endTime);
	
	return days * rate;
}

@Override
public String toString() {
	return "Hotel [name=" + name + ", rate=" + rate + "]";
}
   
   
}
