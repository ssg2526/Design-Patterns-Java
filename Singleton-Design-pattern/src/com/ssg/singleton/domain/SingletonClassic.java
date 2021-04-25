package com.ssg.singleton.domain;
//Lazy initialization
public class SingletonClassic {
	
	private static SingletonClassic obj;
	
	private String var;
	
	private SingletonClassic() {}; // very important line to restrict user to create object
	
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
