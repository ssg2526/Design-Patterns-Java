package com.ssg.singleton;

import com.ssg.singletom.domain.BillPughSingleton;
import com.ssg.singletom.domain.SingletonClassic;

public class Appication {
	
	public static void main(String[] args) {
		//classical singleton
		SingletonClassic obj = SingletonClassic.getInstance();
		obj.setVar("x");
		SingletonClassic obj2 = SingletonClassic.getInstance();
		obj2.setVar("z");
		
		//bill pugh singleton
		BillPughSingleton bps = BillPughSingleton.getInstance();
		bps.setVar("abc");
		BillPughSingleton bps2 = BillPughSingleton.getInstance();
		bps.setVar("abcd");
		
		
		
		System.out.println(bps2.getVar()+"  "+bps.getVar());
		System.out.println(obj.getVar()+"  "+obj2.getVar());
	}

}
