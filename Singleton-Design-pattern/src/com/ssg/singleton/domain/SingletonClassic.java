package com.ssg.singleton.domain;

import java.io.Serializable;

//Lazy initialization
public class SingletonClassic implements Serializable {
	
	private static SingletonClassic obj;
	
	private String var;
	
	/**
	 * The constructor must be made private to avoid users to create new istances
	 * Uncomment exception for making singleton safeguard from reflection 
	 */
	private SingletonClassic() {
		if(obj != null) {
//			throw new RuntimeException("cannot create more than one instances for singleton");
		}
	};
	
	/**
	 * Uncomment below method for making singleton safeguard from serialization
	 */
//	protected Object readResolve() {
//		return obj;
//	}
	
	public static SingletonClassic getInstance() {
		if(obj == null) {
			obj = new SingletonClassic();
		}
		return obj;
	}
	
	public void greet(String name) {
		System.out.println("Hello "+name+"!!!!");
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

}




/* cons - everytime a null check is done
 * 		- In multithreaded environment, it may break singleton property.
 */
