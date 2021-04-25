package com.ssg.factory.example1.domain;

public class CommercialPlan extends Plan {
	
	public CommercialPlan () {
		this.rate = 3.5;
	}

	@Override
	public double getRate() {
		// TODO Auto-generated method stub
		return this.rate;
	}
}
