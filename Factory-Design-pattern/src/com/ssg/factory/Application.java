package com.ssg.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ssg.example1.factory.PlanFactory;
import com.ssg.factory.example1.domain.Plan;
import com.ssg.factory.example1.domain.PlanEnum;

public class Application {

	public static void main(String[] args) throws IOException {
		
		PlanFactory planFactory = new PlanFactory();
		
		System.out.print("Enter plan name to generate bill: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String planName = br.readLine();
		System.out.print("Enter the number of units for calculation: ");
		int units = Integer.parseInt(br.readLine());
		
		Plan p = planFactory.getPlan(PlanEnum.valueOf(planName.toUpperCase()));
		System.out.println("Calculation done with rate of: " +p.getRate());
		System.out.println("The bill amount is: "+p.calculateBill(units));
	}
}
