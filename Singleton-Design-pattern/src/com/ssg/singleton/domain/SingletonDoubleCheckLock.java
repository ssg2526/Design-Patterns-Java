package com.ssg.singleton.domain;

public class SingletonDoubleCheckLock {
	
	private static SingletonDoubleCheckLock obj;
	
	private String var;
	
	private SingletonDoubleCheckLock() {
		if(obj != null) {
			//uncomment it for making singleton safeguard from reflection 
//			throw new RuntimeException("cannot create more than one instances for singleton");
		}
	}
	
	public static SingletonDoubleCheckLock getInstance() {
		if(obj == null) {
			synchronized (SingletonDoubleCheckLock.class) {
				if(obj == null) {
					obj = new SingletonDoubleCheckLock();
				}
			}
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

// only first time performance impact after that no performance impact
