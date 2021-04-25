package com.ssg.example1.factory;

import com.ssg.factory.example1.domain.CommercialPlan;
import com.ssg.factory.example1.domain.DomesticPlan;
import com.ssg.factory.example1.domain.InstitutionalPlan;
import com.ssg.factory.example1.domain.Plan;
import com.ssg.factory.example1.domain.PlanEnum;

public class PlanFactory {

	public Plan getPlan(Enum planType) {
		
		if(planType == PlanEnum.COMMERCIAL) {
			return new CommercialPlan();
		} else if(planType == PlanEnum.DOMESTIC) {
			return new DomesticPlan();
		} else if(planType == PlanEnum.INSTITUTIONAL) {
			return new InstitutionalPlan();
		}
		return null;
	}
}
