package com.jana.designpattern.strategy;

public class RtgsPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("RTGS payment of Rs."+amount+" has been successfull.");
	}

}
