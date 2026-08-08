package com.jana.designpattern.factory;

public class RtgsPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("RTGS payment of Rs."+amount+" has been successfull.");
	}

}
