package com.ssg.factory.example1.domain;

public class DomesticPlan extends Plan {
	
	
	public DomesticPlan() {
		this.rate = 1.5;
	}
	@Override
	public double getRate() {
		return this.rate;
	}
}
