package com.jana.designpattern.factory;

public class NeftPayment implements Payment{
	@Override
	public void pay(double amount) {
		System.out.println("NEFT payment of Rs."+amount+" has been successfull.");
	};
}
