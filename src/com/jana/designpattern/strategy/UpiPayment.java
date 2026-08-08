package com.jana.designpattern.strategy;

public class UpiPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("UPI payment of Rs."+amount+" has been successfull.");
	}

}
