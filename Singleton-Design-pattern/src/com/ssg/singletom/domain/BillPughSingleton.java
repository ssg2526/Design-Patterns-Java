package com.ssg.singletom.domain;

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
