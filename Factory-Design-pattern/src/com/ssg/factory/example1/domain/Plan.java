package com.ssg.factory.example1.domain;

public abstract class Plan {
	
	protected double rate;
	public abstract double getRate();
	
	public double calculateBill(int units) {
		return units*this.rate;
	}
}
