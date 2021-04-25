package com.ssg.singleton.breaking;

import java.lang.reflect.Constructor;

import com.ssg.singleton.domain.BillPughSingleton;
import com.ssg.singleton.domain.EnumSingleton;
import com.ssg.singleton.domain.SingletonClassic;

/**
 * The following methods are basically reflection methods to break the singleton pattern by creating a new instance by calling the constructor.
 * Though this can be prevented by throwing a runtime exception from the constructor of the corresponding class.
 * Check the constructor of each singleton pattern and uncomment the exception line to safeguard the code from reflection attacks.
 * Enum Singletons don't require runtime exceptions to be thrown as there is no constructor for them they are by default safe from reflection.
 */
public class BreakSingletonWithReflection {
	
	public BillPughSingleton breakBillPughSingleton() {
		BillPughSingleton bps3 = null;
		try {
			Constructor cstr = BillPughSingleton.class.getDeclaredConstructor();
			cstr.setAccessible(true);
            bps3 = (BillPughSingleton) cstr.newInstance();
            if(bps3 != null) {
            	bps3.setVar("new bps3");
            }
		} catch(Exception e) {
			System.out.println(e);
		}
		return bps3;
	}
	
	public SingletonClassic breakClassicSingleton() {
		SingletonClassic obj3 = null;
		try {
			Constructor cstr = SingletonClassic.class.getDeclaredConstructor();
			cstr.setAccessible(true);
            obj3 = (SingletonClassic) cstr.newInstance();
            if(obj3 != null) {
            	obj3.setVar("new obj3");
            }
		} catch(Exception e) {
			System.out.println(e);
		}
		return obj3;
	}
	
	public EnumSingleton breakEnumSingleton() {
		EnumSingleton es3 = null;
		try {
			Constructor cstr = EnumSingleton.class.getDeclaredConstructor();
			cstr.setAccessible(true);
			es3 = (EnumSingleton) cstr.newInstance();
			if(es3 != null) {
				es3.setVar("new es3");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return es3;
	}

}
