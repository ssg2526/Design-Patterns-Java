package com.ssg.singleton;

import com.ssg.singleton.breaking.BreakSingletonWithReflection;
import com.ssg.singleton.breaking.BreakSingletonWithSerialization;
import com.ssg.singleton.domain.BillPughSingleton;
import com.ssg.singleton.domain.EnumSingleton;
import com.ssg.singleton.domain.SingletonClassic;

public class Appication {
	
	public static void main(String[] args) {
		
		BreakSingletonWithReflection breakEithReflection = new BreakSingletonWithReflection();
		BreakSingletonWithSerialization breakWithSerialization = new BreakSingletonWithSerialization();
		
		//*******************CLASSICAL SINGLETON************
		SingletonClassic obj = SingletonClassic.getInstance();
		obj.setVar("obj");
		SingletonClassic obj2 = SingletonClassic.getInstance();
		obj2.setVar("obj2");
		
		//******************BILL PUGH SINGLETON*****************
		BillPughSingleton bps = BillPughSingleton.getInstance();
		bps.setVar("bps");
		BillPughSingleton bps2 = BillPughSingleton.getInstance();
		bps.setVar("bps2");
		
		//****************ENUM SINGLETON***************
		EnumSingleton es = EnumSingleton.INSTANCE;
		es.setVar("es");
		EnumSingleton es2 = EnumSingleton.INSTANCE;
		es2.setVar("ss");
		
		
		// *********BREAKING SINGLETON USING REFLECTION********************
		BillPughSingleton bps3 = breakEithReflection.breakBillPughSingleton();
		SingletonClassic obj3 = breakEithReflection.breakClassicSingleton();
		EnumSingleton es3 = breakEithReflection.breakEnumSingleton();
		
		//*********BREAKING SINGLETON USING SERIALIZATION****************
		SingletonClassic obj4 = breakWithSerialization.breakClassicSingleton(obj2);

		
		//***TESTING FINAL RESULTS*******
		System.out.println(bps2.getVar()+"  "+bps.getVar());
		System.out.println(obj.getVar()+"  "+obj2.getVar());
		System.out.println(es.getVar()+"  "+es2.getVar());
		
		
		if(obj4 != obj2) {
			System.out.println("broke classic singleton singleton with serialization: "+obj4.getVar());
		} else {
			System.out.println("unable to break singleton by serialization-> classic singleton");
		}
		
		
		/**
		 * If singleton is breaking with reflection then go to the corresponding class and uncomment the line in constructor
		 * it will start safeguarding from reflection attacks
		 */
		if(bps3 != null) {
			System.out.println("broke bill pugh singleton with reflection: "+bps3.getVar());
		} else {
			System.out.println("unable to break singleton by reflection-> bill pugh");
		}
		
		if(obj3 != null) {
			System.out.println("broke classic singleton singleton with reflection: "+obj3.getVar());
		} else {
			System.out.println("unable to break singleton by reflection-> classic singleton");
		}
		
		if(es3 != null) {
			System.out.println("broke enum singleton with reflection: "+es3.getVar());
		} else {
			System.out.println("unable to break singleton by reflection-> enum singleton");
		}
		
		
	}

}
