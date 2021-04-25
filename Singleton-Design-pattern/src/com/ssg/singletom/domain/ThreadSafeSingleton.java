package com.ssg.singletom.domain;

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton obj;
	
	private String var;
	
	private ThreadSafeSingleton() {}
	
	synchronized public static ThreadSafeSingleton getInstance() {  // synchronized to handle concurrent access
		 if(obj == null) {
			 obj = new ThreadSafeSingleton();
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

// cons - though it is thread safe but every time a thread will have to wait if the other thread is using the method
