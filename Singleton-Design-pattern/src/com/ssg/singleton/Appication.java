package com.ssg.singleton;

import java.lang.reflect.Constructor;

import com.ssg.singleton.domain.BillPughSingleton;
import com.ssg.singleton.domain.EnumSingleton;
import com.ssg.singleton.domain.SingletonClassic;

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
		
		
		
		
		
		
		// BREAKING BILL PUGH
		BillPughSingleton bps3 = null;
		try {
			Constructor[] cstr = BillPughSingleton.class.getDeclaredConstructors();
			cstr[0].setAccessible(true);
            bps3 = (BillPughSingleton) cstr[0].newInstance();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		bps3.setVar("pqr");
		// BILL PUGH BROKE
		
		EnumSingleton es = EnumSingleton.INSTANCE;
		es.setVar("es");
		
		EnumSingleton es2 = EnumSingleton.INSTANCE;
		es2.setVar("ss");
		
		EnumSingleton es3 = null;
		
		/* trying to break enum singleton using reflection
		 */
		try {
			Constructor[] cstr = EnumSingleton.class.getDeclaredConstructors();
			cstr[0].setAccessible(true);
			es3 = (EnumSingleton) cstr[0].newInstance();
		} catch(Exception e) {
			System.out.println(e);
		}
//		es3.setVar("sss");
		
		System.out.println(bps2.getVar()+"  "+bps.getVar()+"  "+bps3.getVar());
		System.out.println(obj.getVar()+"  "+obj2.getVar());
		System.out.println(es.getVar()+"  "+es2.getVar()+ "  "/*+es3.getVar()*/);
		
		
	}

}
