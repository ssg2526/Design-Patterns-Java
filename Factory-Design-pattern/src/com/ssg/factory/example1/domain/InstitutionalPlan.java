package com.ssg.factory.example1.domain;

public class InstitutionalPlan extends Plan{
	
	public InstitutionalPlan() {
		this.rate = 1.5;
	}

	@Override
	public double getRate() {
		// TODO Auto-generated method stub
		return this.rate;
	}
	
	public void printHello() {
		System.out.println("Hello");
	}
}
