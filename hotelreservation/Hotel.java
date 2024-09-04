package com.hotelreservation;

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

@Override
public String toString() {
	return "Hotel [name=" + name + ", rate=" + rate + "]";
}
   
   
}
