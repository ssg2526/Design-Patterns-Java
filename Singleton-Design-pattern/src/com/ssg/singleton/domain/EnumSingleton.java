package com.ssg.singleton.domain;

public enum EnumSingleton {
	INSTANCE;
	
	private String var;

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	

}
