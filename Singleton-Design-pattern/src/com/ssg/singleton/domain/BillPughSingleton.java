package com.ssg.singleton.domain;

public class BillPughSingleton {
	
	/*inner static class is not loaded until it is referenced. so even if mai class is loaded the inner calss will not be loaded which shows that
	 * it is a Lazy initialization rather than eager
	 */
	
	private String var;
	
	private BillPughSingleton() {}
	
	private static class InnerBillPugh{
		private static final BillPughSingleton OBJ = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return InnerBillPugh.OBJ;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

}

/* This is the most used singleton design pattern across the world. It is Thread safe too.
 * This is used over the synchronization because prior to java 5 there were memory management issues which cause the code thread unsafe
 * So Bill came up with this approach of using static inner class
 */

/* cons - This approach can be easily broken by using java reflections so for that EnumSingleton can be used
 * 
 */
