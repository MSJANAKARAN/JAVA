package com.jana.multithreading;

public class ExtendingThreadClass extends Thread {
	
	public String name;
	public ExtendingThreadClass() {
		//
	}
	public ExtendingThreadClass(String name) {
		this.name = name;
	}
//	The @Override tag is entirely optional in Java.
//	When you write a method in a subclass that matches the exact name, return type, and 
//	parameters of a method in the parent class (like public void run()), 
//	Java automatically overrides it behind the scenes.
	
	
//	Even though your code runs perfectly without it, 
//	keeping the @Override annotation is a best practice for two critical reasons:
//		It catches spelling mistakes
//		It improves readability


	public void run() {
		System.out.println("Executing Thread task: "+Thread.currentThread().getName() + " playing " +name);
	}
}
